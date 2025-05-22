package com.peterpopma.easysix.organizationquery.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "postal_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostalInfo {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String name;

    @Column
    private String street1;

    @Column
    private String street2;

    @Column
    private String street3;

    @Column(nullable = false)
    private String city;

    @Column
    private String sp;

    @Column
    private String pc;

    @Column(nullable = false)
    private String cc;
}
