package com.springkafka.reservations.model;

import lombok.Data;

@Data
public class Reservation {
    private Long id;
    private String clientName;
    private String clientPhone;
}
