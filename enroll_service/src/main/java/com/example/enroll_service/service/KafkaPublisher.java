package com.example.enroll_service.service;


import com.example.enroll_service.config.KafkaConstant;
import com.example.enroll_service.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaPublisher.class);

    @Autowired
    private KafkaTemplate template;

    public void sendNotificationToTopic(Notification notification){
        try {
            CompletableFuture<SendResult<String,Object>> future = template.send(KafkaConstant.KAFKA_TOPIC,notification);
            future.whenComplete((result,ex) ->{
                if(ex == null){
                    LOGGER.info("Sent message=[" + notification.toString() +"] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    LOGGER.info("Unable to send message=[" +notification.toString() + "] due to : " + ex.getMessage());
                }
            } );
        } catch (Exception ex){
            LOGGER.info("Error while send notification to topic:"+ex,ex);
        }
    }
}
