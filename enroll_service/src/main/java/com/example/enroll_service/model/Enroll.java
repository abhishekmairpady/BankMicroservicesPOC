package com.example.enroll_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Enroll_Details")
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int clientId;
    String clientType;
    String affiliationType;
    String serviceType;
    String isDualAdmin;
    long taxNo;

    public Enroll() {
    }

    public Enroll(int clientId, String clientType, String affiliationType, String serviceType, String isDualAdmin, long taxNo) {
        this.clientId = clientId;
        this.clientType = clientType;
        this.affiliationType = affiliationType;
        this.serviceType = serviceType;
        this.isDualAdmin = isDualAdmin;
        this.taxNo = taxNo;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getAffiliationType() {
        return affiliationType;
    }

    public void setAffiliationType(String affiliationType) {
        this.affiliationType = affiliationType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getIsDualAdmin() {
        return isDualAdmin;
    }

    public void setIsDualAdmin(String isDualAdmin) {
        this.isDualAdmin = isDualAdmin;
    }

    public long getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(long taxNo) {
        this.taxNo = taxNo;
    }
}
