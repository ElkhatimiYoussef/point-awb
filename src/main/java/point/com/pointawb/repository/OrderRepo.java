package point.com.pointawb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import point.com.pointawb.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

}
