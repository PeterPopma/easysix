package com.peterpopma.easysix.organizationquery.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "organization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "org_id", nullable = false, unique = true)
    private String orgId;

    @Column(name = "parent_id")
    private String parentId;

    @Column
    private String voice;

    @Column
    private String voiceExtension;

    @Column
    private String fax;

    @Column
    private String faxExtension;

    @Column
    private String email;

    @Column
    private String url;

    @Column(name = "cl_id")
    private String clId;

    @Column(name = "cr_id", nullable = false)
    private String crId;

    @Column(name = "cr_date", nullable = false)
    private OffsetDateTime crDate;

    @Column(name = "up_id")
    private String upId;

    @Column(name = "up_date")
    private OffsetDateTime upDate;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrganizationStatus> statuses;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrganizationRole> roles;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrganizationContact> contacts;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostalInfo> postalInfos;
}
