package com.peterpopma.easysix.domaincommand.dao;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthInfo {
  @Column(name = "pw")
  private String pw;
  @Column(name = "ext")
  private String ext;
}
