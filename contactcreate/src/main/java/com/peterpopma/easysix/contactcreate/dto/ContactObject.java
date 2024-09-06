package com.peterpopma.easysix.contactcreate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactObject {
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
  private ContactAuthInfo authInfo;

}
