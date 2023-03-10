package com.springkafka.notifications.events;

import com.springkafka.notifications.model.Reservation;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReservationCreatedEvent extends NotificationEvent<Reservation>{
}
