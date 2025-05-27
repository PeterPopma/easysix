package com.peterpopma.easysix.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "domain_host_attr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainHostAttribute {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    private Domain domain;

    @Column(nullable = false)
    private String hostName;

    @Version
    private Long version;

    @OneToMany(mappedBy = "hostAttr", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DomainHostAddress> addresses = new ArrayList<>();
}
