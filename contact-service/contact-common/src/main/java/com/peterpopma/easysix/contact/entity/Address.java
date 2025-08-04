package com.peterpopma.easysix.contactcommand.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "addr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Version
    @Column(name = "version")
    private Integer version;

    @OneToOne
    @JoinColumn(name = "postal_info_id", nullable = false)
    private PostalInfo postalInfo;

    private String street1;
    private String street2;
    private String street3;

    @Column(nullable = false)
    private String city;

    private String sp;
    private String pc;

    @Column(nullable = false, length = 2)
    private String cc;
}
