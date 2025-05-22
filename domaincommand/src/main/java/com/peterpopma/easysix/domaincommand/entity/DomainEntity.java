package com.peterpopma.easysix.domaincommand.entity;

import java.util.UUID;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "domain")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DomainEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;

        @Column(nullable = false)
        private String roid;

        @Column(nullable = false)
        private String status;

        // Bi-directional relationship with DomainContactRole
        @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL)
        private List<DomainContactRoleEntity> contactRoles;

        // Bi-directional relationship with DomainContactRole
        @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL)
        private List<DomainHostEntity> domainHosts;

        @Column
        private String clID;
        @Column
        private String crID;
        @Column
        private String crDate;
        @Column
        private String upID;
        @Column
        private String upDate;
        @Column
        private String exDate;
        @Column
        private String trDate;
        @Column
        private Character periodType;
        @Column
        private Short periodValue;
}
