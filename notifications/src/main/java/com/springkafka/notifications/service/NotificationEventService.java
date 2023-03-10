package com.springkafka.notifications.service;

import com.springkafka.notifications.events.NotificationEvent;
import com.springkafka.notifications.events.ReservationCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationEventService {
    @KafkaListener(
            topics = "${topic.reservation.name:reservations}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumer(NotificationEvent<?> event) {
        if (event.getClass().isAssignableFrom(ReservationCreatedEvent.class)) {
            ReservationCreatedEvent reservationCreatedEvent = (ReservationCreatedEvent) event;
            log.info("Received Reservation created event .... with Id={}, data={}",
                    reservationCreatedEvent.getId(),
                    reservationCreatedEvent.getData().toString());
        }

    }
}
