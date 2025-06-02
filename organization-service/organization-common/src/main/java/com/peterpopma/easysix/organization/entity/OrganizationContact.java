package com.peterpopma.easysix.organization.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "organization_contact")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "organization")
public class OrganizationContact {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(name = "contact_type", nullable = false)
    private String contactType;

    @Column(name = "contact_type_name")
    private String contactTypeName;

    @Column(name = "contact_id")
    private String contactId;

    @Version
    @Column(nullable = false)
    private long version;
}
