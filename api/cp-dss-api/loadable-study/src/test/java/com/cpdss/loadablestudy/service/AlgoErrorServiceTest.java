/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.service;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cpdss.common.generated.LoadableStudy;
import com.cpdss.common.scheduler.ScheduledTaskRequest;
import com.cpdss.loadablestudy.entity.AlgoErrorHeading;
import com.cpdss.loadablestudy.entity.AlgoErrors;
import com.cpdss.loadablestudy.entity.LoadablePattern;
import com.cpdss.loadablestudy.repository.*;
import io.grpc.internal.testing.StreamRecorder;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(
    classes = {
      AlgoErrorService.class,
    })
public class AlgoErrorServiceTest {
  @Autowired AlgoErrorService algoErrorService;
  @MockBean AlgoErrorsRepository algoErrorsRepository;
  @MockBean AlgoErrorHeadingRepository algoErrorHeadingRepository;
  @MockBean ScheduledTaskRequest scheduledTaskRequest;
  @MockBean LoadableStudyRepository loadableStudyRepository;
  @MockBean LoadablePatternRepository loadablePatternRepository;
  @MockBean LoadableStudyAlgoStatusRepository loadableStudyAlgoStatusRepository;

  private static final String SUCCESS = "SUCCESS";
  private static final String FAILED = "FAILED";

  @Test
  void testSaveAlgoError() {
    com.cpdss.common.generated.LoadableStudy.AlgoErrors request =
        LoadableStudy.AlgoErrors.newBuilder()
            .setErrorHeading("1")
            .setId(1l)
            .addAllErrorMessages(Arrays.asList("1"))
            .build();
    AlgoErrorHeading heading = new AlgoErrorHeading();
    heading.setId(1l);
    heading.setErrorHeading("1");
    when(algoErrorHeadingRepository.findByErrorHeading(anyString()))
        .thenReturn(Optional.of(heading));

    StreamRecorder<LoadableStudy.AlgoErrors> responseObserver = StreamRecorder.create();
    algoErrorService.saveAlgoError(request, responseObserver);
    List<LoadableStudy.AlgoErrors> replies = responseObserver.getValues();
    Assert.assertEquals(1, replies.size());
    assertNull(responseObserver.getError());
    Assert.assertEquals(SUCCESS, replies.get(0).getResponseStatus().getStatus());
  }

  @Test
  void testSaveAlgoErrorWithException() {
    com.cpdss.common.generated.LoadableStudy.AlgoErrors request =
        LoadableStudy.AlgoErrors.newBuilder().setErrorHeading("1").setId(1l).build();
    AlgoErrorService spyService = Mockito.spy(this.algoErrorService);
    when(algoErrorHeadingRepository.findByErrorHeading(anyString()))
        .thenThrow(new RuntimeException("1"));
    StreamRecorder<LoadableStudy.AlgoErrors> responseObserver = StreamRecorder.create();
    spyService.saveAlgoError(request, responseObserver);
    List<LoadableStudy.AlgoErrors> replies = responseObserver.getValues();
    Assert.assertEquals(1, replies.size());
    assertNull(responseObserver.getError());
    Assert.assertEquals(FAILED, replies.get(0).getResponseStatus().getStatus());
  }

  @Test
  void testSaveAlgoInternalServerError() {
    when(loadablePatternRepository.findByIdAndIsActive(anyLong(), anyBoolean()))
        .thenReturn(Optional.of(new LoadablePattern()));
    when(algoErrorsRepository.save(any(AlgoErrors.class))).thenReturn(new AlgoErrors());

    algoErrorService.saveAlgoInternalServerError(1l, null, true, "1");
    verify(algoErrorsRepository).save(any(AlgoErrors.class));
  }

  @Test
  void testSaveAlgoInternalServerErrorElse() {
    when(loadableStudyRepository.findByIdAndIsActive(anyLong(), anyBoolean()))
        .thenReturn(Optional.of(new com.cpdss.loadablestudy.entity.LoadableStudy()));
    when(algoErrorsRepository.save(any(AlgoErrors.class))).thenReturn(new AlgoErrors());

    algoErrorService.saveAlgoInternalServerError(1l, null, false, "1");
    verify(algoErrorsRepository).save(any(AlgoErrors.class));
  }
}
