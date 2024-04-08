package com.example.enroll_service.config;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory producerFactory(){
        Map<String,Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_URI);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);
//        config.put(org.springframework.kafka.support.serializer.JsonSerializer.TYPE_MAPPINGS, "cat:com.example.enroll_service.model.Notification");
//        config.put(org.springframework.kafka.support.serializer.JsonSerializer.TYPE_MAPPINGS, "Notification: com.example.enroll_service.model.Notification ");


        return new DefaultKafkaProducerFactory(config);
    }

    @Bean
    public KafkaTemplate<String, ?> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

//    @Bean
//    public ConsumerFactory consumerFactory(){
//        Map<String,Object> configMap = new HashMap<>();
//
//        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_URI);
//        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstant.GROUP_ID);
//        configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");
//        configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "com.brillio.kafka.entity");//package where out dto class exists
//
//        return new DefaultKafkaConsumerFactory(configMap);
//    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, UserDto> kafkaListenerContainerFactory(){
//        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }

}
