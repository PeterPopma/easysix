package com.peterpopma.easysix.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "domain")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Domain {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    private String clId;
    private String crId;

    private Instant crDate;
    private String upId;
    private Instant upDate;
    private Instant exDate;
    private Instant trDate;

    private String authInfoPw;
    private String authInfoExt;

    private UUID registrarId;
    private UUID resellerId;

    @Column(nullable = false)
    private Instant createdAt = Instant.now();

    @Column(nullable = false)
    private Instant updatedAt = Instant.now();

    @Version
    @Column(nullable = false)
    private Long version;

    @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DomainStatus> statuses = new ArrayList<>();

    @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DomainHostObject> hostObjs = new ArrayList<>();

    @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DomainHostAttribute> hostAttrs = new ArrayList<>();

    @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DomainOrganization> organizations = new ArrayList<>();
}
