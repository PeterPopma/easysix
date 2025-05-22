package com.peterpopma.easysix.domaincommand.dto;

import java.util.List;
import java.util.UUID;

public record DomainDto(
  UUID id,
  String roid,
  Character periodType,
  Short periodValue,
  String status,
  UUID registrant,
  UUID adminC,
  List<UUID> techC,
  List<UUID> hosts,
  String clID,
  String crID,
  String crDate,
  String upID,
  String upDate,
  String exDate,
  String trDate)
  {}
