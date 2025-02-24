package com.peterpopma.easysix.contactcommand.dao;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        UUID id;

        @Column(name = "roid")
        String roid;

        @Column(name = "status")
        String status;

        @Column(name = "postal_info")
        String postalInfo;

        @Column(name = "name")
        String name;

        @Column(name = "org")
        String org;

        @Column(name = "street1")
        String street1;

        @Column(name = "street2")
        String street2;

        @Column(name = "street3")
        String street3;

        @Column(name = "state_province")
        String stateProvince;

        @Column(name = "postal_code")
        String postalCode;

        @Column(name = "city")
        String city;

        @Column(name = "country_code")
        String countryCode;

        @Column(name = "voice")
        String voice;

        @Column(name = "fax")
        String fax;

        @Column(name = "email")
        String email;

        @Column(name = "cl_id")
        UUID clId;

        @Column(name = "cr_id")
        UUID crId;

        @Column(name = "cr_date")
        Instant crDate;

        @Column(name = "up_id")
        UUID upId;

        @Column(name = "up_date")
        Instant upDate;

        @Column(name = "tr_date")
        Instant trDate;

        @Column(name = "auth_info_pw")
        String authInfoPw;

        @Column(name = "auth_info_ext")
        String authInfoExt;

        @Column(name = "disclose_voice")
        boolean discloseVoice;

        @Column(name = "disclose_email")
        boolean discloseEmail;
}


