package com.example.Notification.service;

import com.example.Notification.exception.SVBException;
import com.example.Notification.model.NotificationEntity;
import com.example.Notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceService {

    @Autowired
    NotificationRepository notificationRepository;

    public NotificationEntity addNotification(NotificationEntity notificationEntity) {
        return  notificationRepository.save(notificationEntity);
    }

    public List<NotificationEntity> getNotifications() throws SVBException {
        List<NotificationEntity> allUsers= new ArrayList<>();
        notificationRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

    public NotificationEntity getNotification(int notificationId) throws SVBException {
        Optional<NotificationEntity> optional = notificationRepository.findById(notificationId);
        NotificationEntity notificationEntity = optional.orElseThrow(() -> new SVBException("Service.USER_NOT_FOUND"));
        return notificationEntity;
    }

    public void deleteNotification(int notificationId) {
        notificationRepository.deleteById(notificationId);
    }
}
