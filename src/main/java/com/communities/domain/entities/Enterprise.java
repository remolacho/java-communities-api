package com.communities.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "enterprises")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rut", nullable = false)
    private String rut;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "subdomain", nullable = false)
    private String subdomain;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "reference_regex")
    private String referenceRegex;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "address")
    private String address;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date updatedAt;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReferenceRegex() {
        return referenceRegex;
    }

    public void setReferenceRegex(String referenceRegex) {
        this.referenceRegex = referenceRegex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}