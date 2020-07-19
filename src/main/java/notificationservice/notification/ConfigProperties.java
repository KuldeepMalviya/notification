package notificationservice.notification;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "configs")
public class ConfigProperties {
   private int afterAlertBreakTime;
   private int monitorTimeWindow;
   private int infoCountLimit;
   private List<String> infoSubscriber;
   private int warningCountLimit;
   private List<String> warningSubscriber;
   private int criticalCountLimit;
   private List<String> criticalSubscriber;
   private int blockerCountLimit;
   private List<String> blockerSubscriber;

}
