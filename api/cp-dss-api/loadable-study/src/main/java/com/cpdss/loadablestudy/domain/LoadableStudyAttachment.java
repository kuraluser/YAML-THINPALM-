/* Licensed at AlphaOri Technologies */
package com.cpdss.loadablestudy.domain;

import lombok.Data;

@Data
public class LoadableStudyAttachment {
  private String filePath;
  private String fileName;
  private Long id;
  private byte[] content;
}
