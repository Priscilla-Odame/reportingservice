package reportingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reportingservice.dto.OrderDto;
import reportingservice.services.LoggingService;

@RestController

public class LoggingController {
    @Autowired
    LoggingService loggingService;

    @PostMapping(value="/logorder")
    public void logOrder(@RequestBody OrderDto orderdto){
    loggingService.logOrder(orderdto);
    }

    @PutMapping(value="/logorder/{id}")
    public void updateOrder(@RequestBody OrderDto orderDto, @PathVariable String id){
        loggingService.updateOrder(orderDto, id);
    }

    @PutMapping(value="order/delete/{id}")
    public void changeOrderToCancelled(@PathVariable String id){
        loggingService.changeOrderToCancelled(id);
    }
}
