package notificationservice.notification;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import notificationservice.notification.notifirs.EventType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;

@Setter
@Getter
@RequiredArgsConstructor
@Repository
public class DataRepository {
   private final ConfigProperties configProperties;
   private static Queue<Data> logsData = new ArrayDeque<>();
   public static int criticalCount = 0;
   public static int infoCount = 0;
   public static int blockerCount = 0;
   public static int waringCount = 0;

   public void addLogs(Data data) {
      removeLogs();
      logsData.add(data);
      incrementCount(data.getEventType());
   }

   private void removeLogs() {
      if (logsData.isEmpty()) {
         return;
      }
      LocalDateTime referenceTime = LocalDateTime.now().minusSeconds(configProperties.getMonitorTimeWindow());
      while (!logsData.isEmpty() && logsData.peek().getEventTime().isBefore(referenceTime)) {
         Data poll = logsData.poll();
         decrementCount(poll.getEventType());
      }
   }

   private void decrementCount(EventType eventType) {
      switch (eventType) {
         case CRITICAL:
            if (criticalCount > 0) {
               criticalCount--;
            }
            break;
         case INFO:
            if (infoCount > 0) {
               infoCount--;
            }
            break;
         case WARNING:
            if (waringCount > 0) {
               waringCount--;
            }
            break;
         case BLOCKER:
            if (blockerCount > 0) {
               blockerCount--;
            }
      }
   }

   private void incrementCount(EventType eventType) {
      switch (eventType) {
         case CRITICAL:
            criticalCount++;
            break;
         case INFO:
            infoCount++;
            break;
         case WARNING:
            waringCount++;
            break;
         case BLOCKER:
            blockerCount++;
      }
   }
}
