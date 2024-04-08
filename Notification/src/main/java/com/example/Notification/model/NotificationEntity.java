package com.example.Notification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class NotificationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long seqId;
    String notificationType;
    String message;
    String email;
    long phone;
    long clientId;

    public NotificationEntity() {
    }

    public NotificationEntity(long seqId, String notificationType, String message, String email, long phone, long clientId) {
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
