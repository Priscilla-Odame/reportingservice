package reportingservice.queues;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import reportingservice.dto.OrderDto;
import reportingservice.services.LoggingService;

@Component
public class MessageListener {
    LoggingService loggingService = new LoggingService();

    @RabbitListener(queues = MConfig.QUEUE)
    public void listener(OrderDto order){
//        System.out.println(order);
        loggingService.logOrder(order);

    }
}
