package point.com.pointawb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import point.com.pointawb.dao.OrderDao;
import point.com.pointawb.dao.SaleDao;
import point.com.pointawb.dto.OrderDto;
import point.com.pointawb.entity.OrderEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequestMapping(path = "/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private SaleDao saleDao;

    @PostMapping(path = "/save-order")
    public OrderEntity saveOrder(@RequestBody List<OrderDto> orderDto) {

        final Logger logger = LoggerFactory.getLogger(ProductController.class);

        logger.info("Saving order...");

        OrderEntity savedOrder = this.saleDao.saveSale(orderDto);

        if (savedOrder != null) {
            logger.info("Order Id: {}", savedOrder.getOrderId());
            logger.info("Total: {}", savedOrder.getTotal());
        } else {
            logger.info("Failed to save order.");
        }

        return savedOrder;
   }

    @GetMapping(path = "/get-order")
    public List<OrderEntity> getAllOrders() {
        final Logger logger = LoggerFactory.getLogger(ProductController.class);

        logger.info("Retrieving all orders:");

        List<OrderEntity> allOrders = this.orderDao.getAllOrders();

        for (OrderEntity order : allOrders) {
            logger.info("Order ID: {}", order.getOrderId());
            logger.info("Total: {}", order.getTotal());
        }

        return allOrders;
   }

}

