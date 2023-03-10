package com.springkafka.reservations.service;

import com.springkafka.reservations.enums.ReservationEventType;
import com.springkafka.reservations.events.ReservationCreatedEvent;
import com.springkafka.reservations.events.ReservationEvent;
import com.springkafka.reservations.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReservationEventsService {

    private final KafkaTemplate<String, ReservationEvent<?>> producer;

    @Value("${topic.reservation.name:reservations}")
    private String topicReservation;

    public void publish(Reservation reservation) {
        ReservationCreatedEvent created = new ReservationCreatedEvent();
        created.setId(UUID.randomUUID().toString());
        created.setType(ReservationEventType.CREATED);
        created.setDate(new Date());
        created.setData(reservation);
        this.producer.send(topicReservation, created);
    }
}
