package com.test.SpringkKafkaP.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration

public class KafkaProducerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String  boostrapServers;

    public Map <String , Object> producerConfig(){
        HashMap<String,Object> proper = new HashMap<>();
        proper.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,boostrapServers);
        proper.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        proper.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return proper;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory (){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate (ProducerFactory<String, String> producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }

}

