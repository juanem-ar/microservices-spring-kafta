package com.springkafka.reservations.service;

import com.springkafka.reservations.model.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationEventsService reservationEventsService;

    public Reservation save(Reservation reservation){
        System.out.println("Received: " + reservation);
        this.reservationEventsService.publish(reservation);
        return reservation;
    }


}
