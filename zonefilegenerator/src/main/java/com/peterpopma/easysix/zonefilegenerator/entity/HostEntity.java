package com.peterpopma.easysix.zonefilegenerator.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "host")
public class HostEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;  // UUID type with default gen_random_uuid()

    @Column(name = "name", nullable = false)
    private String name;  // Host name

    @Column(name = "roid", nullable = false)
    private String roid;  // ROID

    @Column(name = "status")
    private String status;  // Status of the host (can be null)

    @Column(name = "maintainer_id")
    private UUID maintainerId;  // Maintainer UUID (can be null)

    @Column(name = "domain_id")
    private UUID domainId;  // Domain UUID (can be null)

    @Column(name = "cl_id")
    private UUID clId;  // Client ID (can be null)

    @Column(name = "cr_id")
    private UUID crId;  // Creator ID (can be null)

    @Column(name = "up_id")
    private UUID upId;  // Updater ID (can be null)

    @Column(name = "cr_date")
    private LocalDateTime crDate;  // Creation date (can be null)

    @Column(name = "up_date")
    private LocalDateTime upDate;  // Update date (can be null)

    @Column(name = "tr_date")
    private LocalDateTime trDate;  // Transfer date (can be null)

    @ManyToOne
    @JoinColumn(name = "domain_id") // Matches the foreign key column in the database
    private DomainEntity domain;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoid() {
        return roid;
    }

    public void setRoid(String roid) {
        this.roid = roid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getMaintainerId() {
        return maintainerId;
    }

    public void setMaintainerId(UUID maintainerId) {
        this.maintainerId = maintainerId;
    }

    public UUID getDomainId() {
        return domainId;
    }

    public void setDomainId(UUID domainId) {
        this.domainId = domainId;
    }

    public UUID getClId() {
        return clId;
    }

    public void setClId(UUID clId) {
        this.clId = clId;
    }

    public UUID getCrId() {
        return crId;
    }

    public void setCrId(UUID crId) {
        this.crId = crId;
    }

    public UUID getUpId() {
        return upId;
    }

    public void setUpId(UUID upId) {
        this.upId = upId;
    }

    public LocalDateTime getCrDate() {
        return crDate;
    }

    public void setCrDate(LocalDateTime crDate) {
        this.crDate = crDate;
    }

    public LocalDateTime getUpDate() {
        return upDate;
    }

    public void setUpDate(LocalDateTime upDate) {
        this.upDate = upDate;
    }

    public LocalDateTime getTrDate() {
        return trDate;
    }

    public void setTrDate(LocalDateTime trDate) {
        this.trDate = trDate;
    }
}
