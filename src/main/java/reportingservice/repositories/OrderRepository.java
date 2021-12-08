package reportingservice.repositories;

import org.springframework.data.repository.CrudRepository;
import reportingservice.entities.Order;

public interface OrderRepository extends CrudRepository<Order, String> {

}
