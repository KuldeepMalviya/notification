package notificationservice.notification.notifirs;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotifierFactory {

   private final InfoNotifier infoNotifier;
   private final WarningNotifier warningNotifier;
   private final CriticalNotifier criticalNotifier;
   private final BlockerNotifier blockerNotifier;

   public Notify getNotifier(EventType evenType) {
      switch (evenType) {
         case INFO:
            return infoNotifier;
         case WARNING:
            return warningNotifier;
         case CRITICAL:
            return criticalNotifier;
         case BLOCKER:
            return blockerNotifier;
      }
      return null;
   }
}
