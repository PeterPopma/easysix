package com.peterpopma.easysix.hostquery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.net.InetAddress;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "host")
@Getter
@Setter
public class HostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    UUID id;

    @Column(nullable = false)
    private String name; // host:name

    @Column(nullable = false)
    private String roid; // host:roid

    @ElementCollection
    @CollectionTable(name = "host_status", joinColumns = @JoinColumn(name = "host_id"))
    @Column(name = "status")
    private List<String> status; // host:status (array in DB)

    @ElementCollection
    @CollectionTable(name = "host_ipv4", joinColumns = @JoinColumn(name = "host_id"))
    @Column(name = "ipv4", columnDefinition = "INET")
    private List<InetAddress> ipv4; // host:addr (IPv4)

    @ElementCollection
    @CollectionTable(name = "host_ipv6", joinColumns = @JoinColumn(name = "host_id"))
    @Column(name = "ipv6", columnDefinition = "INET")
    private List<InetAddress> ipv6; // host:addr (IPv6)

    @Column(nullable = false)
    private String clId; // host:clID

    @Column(nullable = false)
    private String crId; // host:crID

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime crDate; // host:crDate

    private String upId; // host:upID

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime upDate; // host:upDate

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime trDate; // host:trDate
}
