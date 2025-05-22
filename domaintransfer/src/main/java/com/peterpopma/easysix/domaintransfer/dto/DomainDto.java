package com.peterpopma.easysix.domaintransfer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DomainDto {
  private String id;
  private String roid;

  private PeriodDto period;
  private String status;
  private String registrant;
  private String adminC;
  private List<String> techC;
  private List<String> hosts;
  private String clID;
  private String crID;
  private String crDate;
  private String upID;
  private String upDate;
  private String exDate;
  private String trDate;
  private AuthInfo authInfo;

}
