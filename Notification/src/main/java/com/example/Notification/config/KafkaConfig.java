package com.example.Notification.config;


import com.example.enroll_service.model.Notification;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

//    @Bean
//    public ProducerFactory producerFactory(){
//        Map<String,Object> config = new HashMap<>();
//
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_URI);
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);
//
//        return new DefaultKafkaProducerFactory(config);
//    }
//
//    @Bean
//    public KafkaTemplate<String, ?> kafkaTemplate(){
//        return new KafkaTemplate<>(producerFactory());
//    }

    @Bean
    public ConsumerFactory consumerFactory(){
        Map<String,Object> configMap = new HashMap<>();

        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_URI);
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonDeserializer.class);
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstant.GROUP_ID);
        configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");
        configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.*");//package where out dto class exists
//        configMap.put(JsonDeserializer.TYPE_MAPPINGS, "Notification: com.example.Notification.model.Notification");


        return new DefaultKafkaConsumerFactory(configMap);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Notification> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
