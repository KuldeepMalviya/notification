package notificationservice.notification.notifirs;

import lombok.RequiredArgsConstructor;
import notificationservice.notification.ConfigProperties;
import notificationservice.notification.DataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BlockerNotifier implements Notify {
   private static LocalDateTime LAST_NOTIFY_TIME = LocalDateTime.now();
   private final ConfigProperties configProperties;

   @Override
   public void notifySubscribers() {
      if (DataRepository.blockerCount >= configProperties.getBlockerCountLimit()) {
         if (!LAST_NOTIFY_TIME.isBefore(LocalDateTime.now().minusSeconds(configProperties.getAfterAlertBreakTime()))) {
            return;
         }
         System.out.println("Notify Blocker subscriber -:: " + configProperties.getBlockerSubscriber());
         LAST_NOTIFY_TIME = LocalDateTime.now();
      }
   }
}
