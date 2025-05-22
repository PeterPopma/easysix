package com.peterpopma.easysix.domaintransfer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto {
  private String id;
  private String roid;
  private String email;
  private String telephone;
  private String street;
  private String postalCode;
  private String city;
  private String country;
  private String clID;
  private String crID;
  private String crDate;
  private String upID;
  private String upDate;
  private String exDate;
  private String trDate;
  private AuthInfo authInfo;

}
