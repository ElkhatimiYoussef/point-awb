package point.com.pointawb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import point.com.pointawb.dao.SaleDao;
import point.com.pointawb.entity.ProductEntity;
import point.com.pointawb.entity.SaleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RequestMapping(path = "/sales")
@RestController
public class SalesController {
    @Autowired
    private SaleDao saleDao;

    @GetMapping(path = "/get-sales")
    public List<SaleEntity> getSales() {
        final Logger logger = LoggerFactory.getLogger(ProductController.class);

        List<SaleEntity> sales = this.saleDao.getSales();

        for (SaleEntity sale : sales) {
            logger.info("Sale ID: {}", sale.getSalesId());
            logger.info("Product ID: {}", sale.getProductId());
            logger.info("Order ID: {}", sale.getOrderId());

            ProductEntity product = sale.getProduct();
            if (product != null) {
                logger.info("Product Details:");
                logger.info("\tProduct ID: {}", product.getProductId());
                logger.info("\tProduct Name: {}", product.getProductName());
                logger.info("\tProduct Price: {}", product.getProductPrice());
                logger.info("\tBarcode: {}", product.getBarcode());
            }

            logger.info("   ");

        }

        return sales;
    }

    @GetMapping(path = "/get-by-order-id")
    public List<SaleEntity> getSaleByOrderId(@RequestParam Integer orderId) {
        final Logger logger = LoggerFactory.getLogger(ProductController.class);

        List<SaleEntity> sales = this.saleDao.getSaleByOrderId(orderId);

        for (SaleEntity sale : sales) {
            logger.info("Sale ID: {}", sale.getSalesId());
            logger.info("Product ID: {}", sale.getProductId());
            logger.info("Order ID: {}", sale.getOrderId());

            ProductEntity product = sale.getProduct();
            if (product != null) {
                logger.info("Product Details:");
                logger.info("\tProduct ID: {}", product.getProductId());
                logger.info("\tProduct Name: {}", product.getProductName());
                logger.info("\tProduct Price: {}", product.getProductPrice());
                logger.info("\tBarcode: {}", product.getBarcode());
            }

            logger.info("  "); // Ajoute une ligne vide pour séparer les ventes

        }

        return sales;
    }
}

