package notificationservice.notification;

import notificationservice.notification.notifirs.EventType;

import java.time.LocalDateTime;

@lombok.Data
public class Data {
   //pattern = "yyyy-MM-dd'T'HH:mm:ssZ"
   private LocalDateTime eventTime;
   private EventType eventType;
   private String message;
}
