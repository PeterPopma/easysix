package com.peterpopma.easysix.zonefilegenerator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "domain_contact_roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DomainContactRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "domain_id")
    private DomainEntity domain;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private ContactEntity contactEntity;

    @Column(name = "role")
    private String role;  // Role for the contact in this domain (e.g., admin, technical, billing)
}