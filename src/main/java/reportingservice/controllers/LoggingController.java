package reportingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
}
