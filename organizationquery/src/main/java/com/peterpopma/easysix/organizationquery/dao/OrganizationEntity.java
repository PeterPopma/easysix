package com.peterpopma.easysix.organizationquery.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "organization")
@Getter
@Setter
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    UUID id;

    @Column(name = "organization_id", nullable = false)
    private String organizationId; // org:id

    @Column(name = "roid", nullable = false)
    private String roid; // org:roid

    @Column(name = "role_type")
    private String roleType; // org:type

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "role_status", columnDefinition = "text[]")
    private List<String> roleStatus; // Multiple org:status values

    @Column(name = "role_id")
    private Integer roleId; // org:roleID

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "status", columnDefinition = "text[]")
    private List<String> status; // org:status at root level
    
    @Column(name = "parent_id")
    private String parentId; // org:postalInfo type
    
    @Column(name = "postal_info_type")
    private String postalInfoType; // org:postalInfo type

    @Column(name = "postal_info_name")
    private String postalInfoName; // org:name

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "postal_info_street", columnDefinition = "text[]")
    private List<String> postalInfoStreet; // org:street (array for multiple lines)

    @Column(name = "postal_info_city")
    private String postalInfoCity; // org:city

    @Column(name = "postal_info_state_province")
    private String postalInfoStateProvince; // org:sp

    @Column(name = "postal_info_postal_code")
    private String postalInfoPostalCode; // org:pc

    @Column(name = "postal_info_country_code")
    private String postalInfoCountryCode; // org:cc

    @Column(name = "voice")
    private String voice; // org:voice

    @Column(name = "fax")
    private String fax; // org:fax

    @Column(name = "email")
    private String email; // org:email

    @Column(name = "url")
    private String url; // org:url

    @Column(name = "contact_admin")
    private String contactAdmin; // org:contact type="admin"

    @Column(name = "contact_billing")
    private String contactBilling; // org:contact type="billing"

    @Column(name = "contact_custom")
    private String contactCustom; // org:contact type="custom"

    @Column(name = "cr_id")
    private String crId; // org:crID

    @Column(name = "cr_date")
    private Instant crDate; // org:crDate

    @Column(name = "up_id")
    private String upId; // org:upID

    @Column(name = "up_date")
    private Instant upDate; // org:upDate
}
