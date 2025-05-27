package com.peterpopma.easysix.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "domain_organization", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"domain_id", "organization_id", "role"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainOrganization {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    private Domain domain;

    @Column(nullable = false)
    private UUID organizationId;

    @Column(nullable = false)
    private String role;

    private String status;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    @Column(nullable = false)
    private Instant updatedAt = Instant.now();

    @Version
    private Long version;
}
