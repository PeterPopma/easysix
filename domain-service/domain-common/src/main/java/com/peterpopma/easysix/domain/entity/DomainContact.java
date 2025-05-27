package com.peterpopma.easysix.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "domain_contact", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"domain_id", "role"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainContact {

    @Id
    private UUID id;

    @Column(nullable = false)
    private UUID domainId;

    @Column(nullable = false)
    private UUID contactId;

    @Column(nullable = false)
    private String role;

    @Version
    private Long version;
}
