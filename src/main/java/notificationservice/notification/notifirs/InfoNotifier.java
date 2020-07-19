package notificationservice.notification.notifirs;

import lombok.RequiredArgsConstructor;
import notificationservice.notification.ConfigProperties;
import notificationservice.notification.DataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class InfoNotifier implements Notify {
   private static LocalDateTime LAST_NOTIFY_TIME = LocalDateTime.now();
   private final ConfigProperties configProperties;

   @Override
   public void notifySubscribers() {
      if (DataRepository.infoCount >= configProperties.getInfoCountLimit()) {
         if (!LAST_NOTIFY_TIME.isBefore(LocalDateTime.now().minusSeconds(configProperties.getAfterAlertBreakTime()))) {
            return;
         }
         System.out.println("Notify Info subscriber -:: " + configProperties.getInfoSubscriber());
         LAST_NOTIFY_TIME = LocalDateTime.now();
      }
   }

}
