/* Licensed at AlphaOri Technologies */
package com.cpdss.gateway.service.vesselinfo;

import com.cpdss.common.generated.VesselInfo;
import com.cpdss.gateway.domain.vessel.VesselValveEdu;
import com.cpdss.gateway.domain.vessel.VesselValveEducationProcess;
import com.cpdss.gateway.domain.vessel.VesselValveSeq;
import com.cpdss.gateway.domain.vessel.VesselValveSequence;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VesselValveService {

  public Map<String, Map<String, Map<String, VesselValveSeq>>> buildVesselValveResponse(
      List<VesselInfo.VesselValveSequence> grpcReplyList) {
    List<VesselValveSequence> list = this.buildVesselValveSequenceDomain(grpcReplyList);
    Map<String, List<VesselValveSequence>> map1 =
        list.stream().collect(Collectors.groupingBy(VesselValveSequence::getSequenceTypeName));
    Map<String, Map<String, Map<String, VesselValveSeq>>> map11 = new HashMap<>();
    for (Map.Entry<String, List<VesselValveSequence>> var2 : map1.entrySet()) {
      Map<String, List<VesselValveSequence>> map2 =
          var2.getValue().stream()
              .collect(Collectors.groupingBy(VesselValveSequence::getSequenceOperationName));
      Map<String, Map<String, VesselValveSeq>> map3 = new HashMap<>();
      for (Map.Entry<String, List<VesselValveSequence>> seqEntityList : map2.entrySet()) {
        Map<String, VesselValveSeq> map4 =
            new TreeMap<>(
                new Comparator<String>() {
                  @Override
                  public int compare(String o1, String o2) {
                    return extractInt(o1) - extractInt(o2);
                  }

                  int extractInt(String s) {
                    String num = s.replaceAll("\\D", "");
                    // return 0 if no digits found
                    return num.isEmpty() ? 0 : Integer.parseInt(num);
                  }
                });
        int x = 1;
        for (VesselValveSequence v : seqEntityList.getValue()) {
          map4.put("sequence_" + x, new VesselValveSeq().getInstance(v));
          x++;
        }
        map3.put(toCamelCase(seqEntityList.getKey()), map4);
      }
      map11.put(toCamelCase(var2.getKey()), map3);
    }
    return map11;
  }

  public static String toCamelCase(final String init) {
    if (init == null || init.isEmpty()) return null;
    final StringBuilder ret = new StringBuilder(init.length());
    List<String> words = Arrays.asList(init.split(" "));
    for (final String word : words) {
      if (!word.isEmpty()) {
        if (words.get(0).equals(word)) {
          ret.append(Character.toLowerCase(word.charAt(0)));
        } else {
          ret.append(Character.toUpperCase(word.charAt(0)));
        }
        ret.append(word.substring(1).toLowerCase());
      }
    }
    return ret.toString();
  }

  public List<VesselValveSequence> buildVesselValveSequenceDomain(
      List<VesselInfo.VesselValveSequence> list) {
    List<VesselValveSequence> sequenceList = new ArrayList<>();
    for (VesselInfo.VesselValveSequence vvs : list) {
      VesselValveSequence sequence = new VesselValveSequence();
      Optional.ofNullable(vvs.getSequenceNumber())
          .ifPresent(
              v -> {
                if (!v.isEmpty()) sequence.setSequenceNumber(new BigDecimal(v));
              });
      BeanUtils.copyProperties(vvs, sequence);
      sequenceList.add(sequence);
    }
    return sequenceList;
  }

  public Map<String, Map<String, List<VesselValveEdu>>> buildVesselValveEductorResponse(
      List<VesselInfo.VesselValveEducationProcess> grpcSource) {
    List<VesselValveEducationProcess> sourceList = buildVesselValveEductorDomain(grpcSource);
    Map<String, List<VesselValveEducationProcess>> map1 =
        sourceList.stream()
            .collect(Collectors.groupingBy(VesselValveEducationProcess::getStepName));
    Map<String, Map<String, List<VesselValveEdu>>> map11 = new HashMap<>();
    for (Map.Entry<String, List<VesselValveEducationProcess>> mp : map1.entrySet()) {
      Map<String, List<VesselValveEdu>> map12 =
          mp.getValue().stream()
              .collect(
                  Collectors.groupingBy(
                      v -> toCamelCase(v.getEductorName()),
                      Collectors.mapping(
                          v -> {
                            return new VesselValveEdu(v.getSequenceNumber(), v.getValveNumber());
                          },
                          Collectors.toList())));
      map11.put(toCamelCase(mp.getKey()), map12);
    }
    return map11;
  }

  public List<VesselValveEducationProcess> buildVesselValveEductorDomain(
      List<VesselInfo.VesselValveEducationProcess> sourceList) {
    List<VesselValveEducationProcess> list = new ArrayList<>();
    for (VesselInfo.VesselValveEducationProcess vve : sourceList) {
      VesselValveEducationProcess eduction = new VesselValveEducationProcess();
      BeanUtils.copyProperties(vve, eduction);
      list.add(eduction);
    }
    return list;
  }
}
