package com.peterpopma.easysix.organizationquery.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "organization_contact")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationContact {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(name = "contact_id", nullable = false)
    private String contactId;

    @Column(name = "contact_type", nullable = false)
    private String type;

    @Column(name = "contact_type_name")
    private String typeName;
}
