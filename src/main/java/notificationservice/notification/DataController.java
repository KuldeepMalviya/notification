package notificationservice.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
public class DataController {

   private final DataProcessService dataProcessService;

   @PutMapping("/data")
   public void processLogData(@RequestBody Data data) {
      // for testing this can be set for log event time
      //  data.setEventTime(LocalDateTime.now());
      dataProcessService.process(data);
   }

}
