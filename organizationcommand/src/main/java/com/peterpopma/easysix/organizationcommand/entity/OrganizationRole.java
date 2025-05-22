package com.peterpopma.easysix.organizationcommand.entity;

import com.peterpopma.easysix.organizationcommand.model.OrganizationRoleStatusType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "organization_role", indexes = {
        @Index(name = "uniq_org_role_type", columnList = "organization_id, type", unique = true)
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"organization", "statuses"})
public class OrganizationRole {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(nullable = false)
    private String type;

    private String roleId;

    @Version
    @Column(nullable = false)
    private long version;

    @OneToMany(mappedBy = "organizationRole", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrganizationRoleStatus> statuses = new HashSet<>();
}
