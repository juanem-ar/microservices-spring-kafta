package com.springkafka.reservations.events;

import com.springkafka.reservations.enums.ReservationEventType;
import lombok.Data;

import java.util.Date;

@Data
public abstract class ReservationEvent <T> {
    private String id;
    private Date date;
    private ReservationEventType type;
    private T data;
}
