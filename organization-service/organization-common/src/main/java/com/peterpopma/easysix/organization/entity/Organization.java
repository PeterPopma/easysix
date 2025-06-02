package com.peterpopma.easysix.organization.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "organization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"roles", "contacts", "statuses", "postalInfos"})
public class Organization {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "org_id", nullable = false, unique = true)
    private String orgId;

    private String roid;
    private String parentId;
    private String voice;
    private String fax;
    private String email;
    private String url;

    @Column(name = "cl_id")
    private String clId;

    @Column(name = "cr_id", nullable = false)
    private String crId;

    @Column(name = "cr_date", nullable = false)
    private Instant crDate;

    @Column(name = "up_id")
    private String upId;

    @Column(name = "up_date")
    private Instant upDate;

    @Version
    @Column(nullable = false)
    private long version;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrganizationStatus> statuses;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrganizationRole> roles;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrganizationContact> contacts;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PostalInfo> postalInfos;

    public void addStatus(OrganizationStatus status) {
        if (status == null) return;
        if (this.statuses == null) this.statuses = new HashSet<>();
        status.setOrganization(this);
        this.statuses.add(status);
    }

    public void addRole(OrganizationRole role) {
        if (this.roles == null) {
            this.roles = new HashSet<>();
        }
        role.setOrganization(this);
        this.roles.add(role);
    }

    public void addContact(OrganizationContact contact) {
        if (contact == null) return;
        if (this.contacts == null) this.contacts = new HashSet<>();
        contact.setOrganization(this);
        this.contacts.add(contact);
    }

    public void addPostalInfo(PostalInfo pi) {
        if (pi == null) return;
        if (this.postalInfos == null) this.postalInfos = new HashSet<>();
        pi.setOrganization(this);
        this.postalInfos.add(pi);
    }
}
