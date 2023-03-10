package com.springkafka.notifications.config;

import com.springkafka.notifications.events.NotificationEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    private final String bootstrapAddress = "localhost:8082";

    @Bean
    public ConsumerFactory<String, NotificationEvent<?>> consumerFactory() {
        Map<String, String> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(JsonSerializer.TYPE_MAPPINGS,"com.springkafka:com.springkafka.notifications.events.NotificationEvent");

        final JsonDeserializer<NotificationEvent<?>> jsonDeserializer = new JsonDeserializer<>();
        return new DefaultKafkaConsumerFactory(
                props,
                new StringDeserializer(),
                jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NotificationEvent<?>>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, NotificationEvent<?>> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
