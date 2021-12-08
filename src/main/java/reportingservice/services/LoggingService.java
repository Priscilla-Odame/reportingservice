package reportingservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reportingservice.dto.OrderDto;
import reportingservice.entities.Order;
import reportingservice.repositories.OrderRepository;

import java.util.Optional;

@Service
public class LoggingService {

    @Autowired
    OrderRepository orderRepository;

    public void logOrder(OrderDto orderdto) {
        Optional<Order> order = orderRepository.findById(orderdto.getId());
        Order newOrder = new Order();

        newOrder.setId(orderdto.getId());
        newOrder.setPrice(orderdto.getPrice());
        newOrder.setProduct(orderdto.getProduct());
        newOrder.setQuantity(orderdto.getQuantity());
        newOrder.setSide(orderdto.getSide());
        newOrder.setStatus(orderdto.getStatus());
        orderRepository.save(newOrder);

    }

    public void updateOrder(OrderDto orderdto, String id) {
        Optional<Order> order = orderRepository.findById(orderdto.getId());

        if (order.isPresent()){
            order.get().setId(orderdto.getId());
            order.get().setProduct(orderdto.getProduct());
            order.get().setPrice(orderdto.getPrice());
            order.get().setQuantity(orderdto.getQuantity());
            order.get().setSide(orderdto.getSide());
            order.get().setStatus(orderdto.getStatus());
            orderRepository.save(order.get());
        }
        else{
            Order newOrder = new Order();
            newOrder.setId(orderdto.getId());
            newOrder.setPrice(orderdto.getPrice());
            newOrder.setProduct(orderdto.getProduct());
            newOrder.setQuantity(orderdto.getQuantity());
            newOrder.setSide(orderdto.getSide());
            newOrder.setStatus(orderdto.getStatus());
            orderRepository.save(newOrder);
        }
    }
}
