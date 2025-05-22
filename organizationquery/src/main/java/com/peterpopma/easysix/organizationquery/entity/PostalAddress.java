package com.peterpopma.easysix.organizationquery.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "postal_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostalAddress {

    @Id
    @GeneratedValue
    private UUID id;

    @ElementCollection
    @CollectionTable(name = "postal_address_streets", joinColumns = @JoinColumn(name = "address_id"))
    @Column(name = "street")
    private java.util.List<String> street;

    @Column(nullable = false)
    private String city;

    private String stateProvince;

    private String postalCode;

    @Column(nullable = false, length = 2)
    private String countryCode;
}
