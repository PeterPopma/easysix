package com.peterpopma.easysix.contactcommand.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "disclose_element")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscloseElement {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "disclose_id", nullable = false)
    private Disclose disclose;

    @Column(name = "element_type", nullable = false)
    private String elementType;

    @Column(name = "loc_type", nullable = false)
    private String locType; // Consider using an enum
}
