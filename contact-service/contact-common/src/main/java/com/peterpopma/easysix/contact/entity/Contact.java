package com.peterpopma.easysix.contactcommand.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "contact")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Long version;

    @Column(name = "contact_id")
    private String contactId;

    private String voice;           // note that we plan to store extensions like <voice x="1234">+1.5555555555</voice> as +1.5555555555x1234
    private String fax;             // note that we plan to store extensions like <voice x="1234">+1.5555555555</voice> as +1.5555555555x1234

    @Column(nullable = false)
    private String email;

    @Column(name = "cl_id", nullable = false)
    private String clId;

    @Column(name = "cr_id", nullable = false)
    private String crId;

    @Column(name = "cr_date", nullable = false)
    private LocalDateTime crDate;

    @Column(name = "up_id")
    private String upId;

    @Column(name = "up_date")
    private LocalDateTime upDate;

    @Column(name = "tr_date")
    private LocalDateTime trDate;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostalInfo> postalInfos = new ArrayList<>();

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private AuthInfo authInfo;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Status> statuses = new ArrayList<>();

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private Disclose disclose;
}

