package com.springkafka.notifications.model;

import com.springkafka.notifications.enums.NotificationEventType;
import lombok.Data;

@Data
public class Reservation {
    private Long id;
    private NotificationEventType type;
    private String clientName;
    private String clientPhone;
}
