package reportingservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoggingController {

    @PostMapping(value="/logorder")
    public void logOrder(){

    }
}
