package com.peterpopma.easysix.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "domain_host_obj")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainHostObject {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    private Domain domain;

    @Column(nullable = false)
    private String hostName;

    @Version
    private Long version;
}
