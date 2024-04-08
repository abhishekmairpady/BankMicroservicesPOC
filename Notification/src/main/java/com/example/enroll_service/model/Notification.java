package com.example.enroll_service.model;

import java.io.Serializable;


public class Notification implements Serializable {

    long seqId;
    String notificationType;
    String message;
    String email;
    long phone;
    long clientId;

    public Notification() {
    }

    public Notification(long seqId, String notificationType, String message, String email, long phone, long clientId) {
        this.seqId = seqId;
        this.notificationType = notificationType;
        this.message = message;
        this.email = email;
        this.phone = phone;
        this.clientId=clientId;
    }

    public long getSeqId() {
        return seqId;
    }

    public void setSeqId(long seqId) {
        this.seqId = seqId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "seqId=" + seqId +
                ", notificationType='" + notificationType + '\'' +
                ", message='" + message + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", clientId=" + clientId +
                '}';
    }
}
