package notificationservice.notification;

import lombok.RequiredArgsConstructor;
import notificationservice.notification.notifirs.NotifierFactory;
import notificationservice.notification.notifirs.Notify;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataProcessService {
   private final DataRepository dataRepository;
   private final NotifierFactory notifierFactory;

   public void process(Data data) {
      dataRepository.addLogs(data);
      Notify notifier = notifierFactory.getNotifier(data.getEventType());
      notifier.notifySubscribers();
   }
}
