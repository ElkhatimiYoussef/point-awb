package point.com.pointawb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import point.com.pointawb.dto.OrderDto;
import point.com.pointawb.entity.OrderEntity;
import point.com.pointawb.repository.OrderRepo;

import java.util.List;

@Service // as component
public class OrderDao {

    @Autowired // dependencies injection
    private OrderRepo orderRepo; // interface

    public OrderEntity saveOrder(List<OrderDto> order) { // calc total
        Double total = 0.0;
        for (OrderDto o : order){
            total += o.getProductPrice();
        }
        OrderEntity orderEntity = new OrderEntity(); // affect and save the total
        orderEntity.setTotal(total);

        return this.orderRepo.save(orderEntity);
    }

    public List<OrderEntity> getAllOrders() { // list of orders
        return this.orderRepo.findAll();
    }
}

