package com.springkafka.reservations.controller;

import com.springkafka.reservations.model.Reservation;
import com.springkafka.reservations.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public Reservation save(@RequestBody Reservation reservation){
        return this.reservationService.save(reservation);
    }

}
