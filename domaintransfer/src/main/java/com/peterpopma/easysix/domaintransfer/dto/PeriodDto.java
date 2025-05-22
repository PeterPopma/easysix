package com.peterpopma.easysix.domaintransfer.dto;

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
