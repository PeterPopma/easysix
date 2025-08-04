package com.peterpopma.easysix.contactcommand.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "auth_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthInfo {

    @Id
    @Column(name = "id")
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Contact contact;

    private String pw;
    private String ext;
}
