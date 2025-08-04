package com.peterpopma.easysix.contactcommand.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "postal_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostalInfo {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Version
    @Column(name = "version")
    private Integer version;

    @ManyToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @Column(nullable = false)
    private String type; // Consider using an enum

    @Column(nullable = false)
    private String name;

    private String org;

    @OneToOne(mappedBy = "postalInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address addr;
}
