package com.peterpopma.easysix.domainquery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PeriodDto {
  private Unit unit;
  private int value;
}
