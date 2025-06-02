package com.peterpopma.easysix.organization.entity;

import com.peterpopma.easysix.organization.model.OrganizationStatusType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organization_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrganizationStatusId.class)
public class OrganizationStatus {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Id
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrganizationStatusType status;
}
