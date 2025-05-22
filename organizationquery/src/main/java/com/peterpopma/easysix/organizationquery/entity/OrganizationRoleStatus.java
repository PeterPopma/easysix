package com.peterpopma.easysix.organizationquery.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "organization_role_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationRoleStatus {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "organization_role_id", nullable = false)
    private OrganizationRole organizationRole;
}
