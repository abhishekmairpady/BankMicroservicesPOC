package com.example.Notification.service;


import com.example.Notification.config.KafkaConstant;
import com.example.Notification.mapper.NotificationMapper;
import com.example.Notification.model.NotificationEntity;
import com.example.enroll_service.model.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final Logger _logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    public NotificationServiceService notificationService;

    @KafkaListener(groupId = KafkaConstant.GROUP_ID,topics = KafkaConstant.KAFKA_TOPIC, containerFactory = KafkaConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void consumeNotification(Notification dto){
        //Store notication from kafka to DB
        try{
            _logger.info("Notification Received from topic:"+ new ObjectMapper().writeValueAsString(dto));
            NotificationEntity notificationEntity= NotificationMapper.MAPPER.covertToEntity(dto);
            NotificationEntity addedNotification=notificationService.addNotification(notificationEntity);
            _logger.info("Notification has stored in DB with Client:"+addedNotification.getClientId());
        } catch (Exception ex){
            _logger.error("Exception while reading user data:"+ex.getMessage());
        }

    }

}
