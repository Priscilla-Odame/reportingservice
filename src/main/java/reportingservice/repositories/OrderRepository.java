package reportingservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reportingservice.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {

}
