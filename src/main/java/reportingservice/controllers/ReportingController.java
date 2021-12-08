package reportingservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reportingservice.entities.Order;
import reportingservice.services.ReportingService;

import java.util.List;
import java.util.Optional;

@RestController
public class ReportingController {

    @Autowired
    ReportingService reportingService;

    @GetMapping(value="/report")
    public List<Order> getReport(){
        return reportingService.getAllOrders();
    }

    @GetMapping(value="/report/{id}")
    public Optional<Order> getReportById(@PathVariable String id){
        return reportingService.getReportById(id);

    }

}
