package com.peterpopma.easysix.organizationcommand.entity;

import com.peterpopma.easysix.organizationcommand.model.OrganizationRoleStatusType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "organization_role_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrganizationRoleStatusId.class)
public class OrganizationRoleStatus {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_role_id", nullable = false)
    private OrganizationRole organizationRole;

    @Id
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrganizationRoleStatusType status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationRoleStatus that)) return false;
        return Objects.equals(organizationRole != null ? organizationRole.getId() : null,
                that.organizationRole != null ? that.organizationRole.getId() : null)
                && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                organizationRole != null ? organizationRole.getId() : null,
                status
        );
    }
}

