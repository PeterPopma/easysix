package com.peterpopma.easysix.organizationcommand.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "postal_info", indexes = {
        @Index(name = "ux_org_postalinfo_type", columnList = "organization_id, type", unique = true)
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "organization")
public class PostalInfo {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String name;

    private String street1;
    private String street2;
    private String street3;
    private String city;

    @Column(name = "state_province")
    private String stateProvince;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country_code", length = 2)
    private String countryCode;

    @Version
    @Column(nullable = false)
    private long version;
}


