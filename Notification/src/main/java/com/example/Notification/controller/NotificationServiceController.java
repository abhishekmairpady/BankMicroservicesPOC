package com.example.Notification.controller;

import com.example.Notification.exception.SVBException;
import com.example.Notification.model.NotificationEntity;
import com.example.Notification.service.NotificationServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationServiceController {

    @Autowired
    NotificationServiceService notificationServiceService;

    @PostMapping("/addNotification")
    public ResponseEntity<NotificationEntity> addNotification(@RequestBody NotificationEntity notificationEntity){
        return new ResponseEntity<>(notificationServiceService.addNotification(notificationEntity),HttpStatus.OK);
    }

    @GetMapping("/getNotifications")
    public ResponseEntity<List<NotificationEntity>> getUsers() throws SVBException {
        return new ResponseEntity<>(notificationServiceService.getNotifications(), HttpStatus.OK);
    }

    @GetMapping("/getNotification/{notificationId}")
    public ResponseEntity<NotificationEntity> getNotification(@PathVariable int notificationId) throws SVBException {
        return new ResponseEntity<>(notificationServiceService.getNotification(notificationId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteNotification/{notificationId}")
    public ResponseEntity<String> deleteUser(@PathVariable int notificationId){
        notificationServiceService.deleteNotification(notificationId);
        return new ResponseEntity<>("Deleted Notification ",HttpStatus.OK);
    }

}
