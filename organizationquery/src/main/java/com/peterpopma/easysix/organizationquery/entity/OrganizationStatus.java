package com.peterpopma.easysix.organizationquery.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "organization_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationStatus {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(name = "status", nullable = false)
    private String status;
}
