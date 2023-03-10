package com.springkafka.reservations.events;

import com.springkafka.reservations.model.Reservation;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReservationCreatedEvent extends ReservationEvent<Reservation> {
}
