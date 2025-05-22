package com.peterpopma.easysix.zonefilegenerator.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "domain_hosts")
public class DomainHostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Surrogate key for simplicity and flexibility

    @Column(name = "sequence_number")
    private Short sequenceNumber;  // `int2` maps to Java `Short`

    @Column(name = "domain_id", nullable = false)
    private UUID domainId;  // Foreign key to the domain table

    @Column(name = "host_id", nullable = false)
    private UUID hostId;  // Foreign key to the host table

    // Relationship to Domain
    @ManyToOne
    @JoinColumn(name = "domain_id", referencedColumnName = "id", insertable = false, updatable = false)
    private DomainEntity domain;

    // Relationship to Host
    @ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "id", insertable = false, updatable = false)
    private HostEntity host;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Short sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public UUID getDomainId() {
        return domainId;
    }

    public void setDomainId(UUID domainId) {
        this.domainId = domainId;
    }

    public UUID getHostId() {
        return hostId;
    }

    public void setHostId(UUID hostId) {
        this.hostId = hostId;
    }

    public DomainEntity getDomain() {
        return domain;
    }

    public void setDomain(DomainEntity domain) {
        this.domain = domain;
    }

    public HostEntity getHost() {
        return host;
    }

    public void setHost(HostEntity host) {
        this.host = host;
    }
}
