package com.peterpopma.easysix.domaincommand.entity;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private UUID id;

        @Column(name = "roid")
        private String roid;

        @Column(name = "status")
        private String status;

        @Column(name = "postal_info")
        private String postalInfo;

        @Column(name = "name")
        private String name;

        @Column(name = "org")
        private String org;

        @Column(name = "street1")
        private String street1;

        @Column(name = "street2")
        private String street2;

        @Column(name = "street3")
        private String street3;

        @Column(name = "state_province")
        private String stateProvince;

        @Column(name = "postal_code")
        private String postalCode;

        @Column(name = "city")
        private String city;

        @Column(name = "country_code")
        private String countryCode;

        @Column(name = "voice")
        private String voice;

        @Column(name = "fax")
        private String fax;

        @Column(name = "email")
        private String email;

        @Column(name = "cl_id")
        private UUID clId;

        @Column(name = "cr_id")
        private UUID crId;

        @Column(name = "cr_date")
        private Instant crDate;

        @Column(name = "up_id")
        private UUID upId;

        @Column(name = "up_date")
        private Instant upDate;

        @Column(name = "tr_date")
        private Instant trDate;

        @Column(name = "auth_info_pw")
        private String authInfoPw;

        @Column(name = "auth_info_ext")
        private String authInfoExt;

        @Column(name = "disclose_voice")
        private boolean discloseVoice;

        @Column(name = "disclose_email")
        private boolean discloseEmail;
}
