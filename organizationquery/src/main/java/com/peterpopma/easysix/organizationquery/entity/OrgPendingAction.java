package com.peterpopma.easysix.organizationquery.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "org_pending_action")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgPendingAction {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String orgId;

    @Column(nullable = false)
    private String paClId;

    @Column(nullable = false)
    private Boolean paResult;

    @Column(nullable = false)
    private String clTrId;

    @Column(nullable = false)
    private String svTrId;

    @Column(nullable = false)
    private OffsetDateTime paDate;
}
