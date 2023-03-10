package com.springkafka.notifications.events;


import com.springkafka.notifications.enums.NotificationEventType;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public abstract class NotificationEvent<T> {
    private String id;
    private Date date;
    private NotificationEventType type;
    private T data;
}
