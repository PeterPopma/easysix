package com.peterpopma.easysix.contactcommand.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "disclose")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disclose {

    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "d")
    private Contact contact;

    @Column(nullable = false)
    private boolean flag;

    @OneToMany(mappedBy = "disclose", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiscloseElement> elements = new ArrayList<>();
}
