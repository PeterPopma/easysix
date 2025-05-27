package com.peterpopma.easysix.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "domain_host_addr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainHostAddress {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "host_attr_id", nullable = false)
    private DomainHostAttribute hostAttr;

    @Column(nullable = false)
    private String ip;

    @Column(nullable = false)
    private String ipVersion;

    @Version
    private Long version;
}
