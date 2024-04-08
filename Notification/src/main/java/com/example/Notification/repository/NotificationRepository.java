package com.example.Notification.repository;

import com.example.Notification.model.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity,Integer> {
}
