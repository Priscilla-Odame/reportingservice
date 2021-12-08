package reportingservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reportingservice.dto.OrderDto;
import reportingservice.entities.Order;
import reportingservice.repositories.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportingService {
    @Autowired
    public OrderRepository orderRepository;

    //Get All Orders
    public List<Order> getAllOrders() {

        List<Order> orders = new ArrayList<>();

        orderRepository.findAll()
                .forEach(orders::add);
        return orders;
    }

    //Get Specific Order
    public Optional<Order> getReportById(String id) {
        return  orderRepository.findById(id);
    }
}
