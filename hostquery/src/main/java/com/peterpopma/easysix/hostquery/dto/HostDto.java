package com.peterpopma.easysix.hostquery.dto;

import java.net.InetAddress;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public record HostDto(
    UUID id,
    String name,
    String roid,
    List<String> status,
    List<InetAddress> ipv4,
    List<InetAddress> ipv6,
    String clId,
    String crId,
    ZonedDateTime crDate,
    String upId,
    ZonedDateTime upDate,
    ZonedDateTime trDate
) {}