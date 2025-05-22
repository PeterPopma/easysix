package com.peterpopma.easysix.organizationquery.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "organization_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationRole {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(name = "role_type", nullable = false)
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "role_id")
    private String roleId;
}
