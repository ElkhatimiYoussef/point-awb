package point.com.pointawb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import point.com.pointawb.dao.ProductDao;
import point.com.pointawb.entity.ProductEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RequestMapping(path = "/products")
@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @PostMapping(path = "/add-product") //Post
    public ProductEntity addProduct(@RequestBody ProductEntity productEntity){
        final Logger logger = LoggerFactory.getLogger(ProductController.class);

        logger.info("Adding product...");
        logger.debug("Product Name: {}, Product Price: {}, Barcode: {}",
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getBarcode());

        ProductEntity addedProduct = this.productDao.addProduct(productEntity);

        String productLog = String.format("Product added: ProductEntity(productId=%d, productName=%s, productPrice=%.2f, barcode=%s)",
                addedProduct.getProductId(),
                addedProduct.getProductName(),
                addedProduct.getProductPrice(),
                addedProduct.getBarcode());

        logger.info(productLog);

        return addedProduct;
    }


    /*
    @GetMapping("/get-all-product") // elasticsearch
    public Iterable<ProductDocument> getAllProdDoc() {
        return productDao.getAllProductDoc();
    }
   */

    @PostMapping(path = "/update-product") //Post
    public ProductEntity updateProduct(@RequestBody ProductEntity productEntity){
        final Logger logger = LoggerFactory.getLogger(ProductController.class);

        logger.info("Updating product...");
        logger.debug("Product ID: {}, Product Name: {}, Product Price: {}, Barcode: {}",
                productEntity.getProductId(),
                productEntity.getProductName(),
                productEntity.getProductPrice(),
                productEntity.getBarcode());

        ProductEntity updatedProduct = this.productDao.updateProduct(productEntity);

        // Construire le message de log sans inclure le champ sale
        String productLog = String.format("Product updated: ProductEntity(productId=%d, productName=%s, productPrice=%.2f, barcode=%s)",
                updatedProduct.getProductId(),
                updatedProduct.getProductName(),
                updatedProduct.getProductPrice(),
                updatedProduct.getBarcode());

        logger.info(productLog);

        return updatedProduct;
    }

    @GetMapping(path = "/delete-product") //Get
    public String deleteProduct(@RequestParam Integer productId){final Logger logger = LoggerFactory.getLogger(ProductController.class);

        logger.info("Deleting product - ID: {}", productId);
        logger.info("Product deleted successfully - ID: {}", productId);

        this.productDao.deleteProduct(productId);

        return "success";
    }

    //Get All Products
    @GetMapping("/list-products")
    public List<ProductEntity> getAllproducts(){
        final Logger logger = LoggerFactory.getLogger(ProductController.class);

        logger.info("Retrieving all products...");

        List<ProductEntity> products = productDao.getAllProducts();

        logger.info("Number of products retrieved: {}", products.size());

        for (ProductEntity product : products) {
            logger.info("Product ID: {}", product.getProductId());
            logger.info("Product Name: {}", product.getProductName());
            logger.info("Product Price: {}", product.getProductPrice());
            logger.info("Barcode: {}", product.getBarcode());
        }

        return products;
    }

    @GetMapping(path = "/get-by-barcode") //Get
    public ProductEntity getProductByBarcode(@RequestParam String barcode) {
        final Logger logger = LoggerFactory.getLogger(ProductController.class);

        logger.info("Retrieving product by barcode: {}", barcode);

        ProductEntity product = this.productDao.getProductByBarcode(barcode);

        if (product != null) {
            logger.info("Product ID: {}", product.getProductId());
            logger.info("Product Name: {}", product.getProductName());
            logger.info("Product Price: {}", product.getProductPrice());
            logger.info("Barcode: {}", product.getBarcode());
        } else {
            logger.info("Product with barcode {} not found", barcode);
        }

        return product;
    }

    @GetMapping(path = "/get-by-id") //Get
    public ProductEntity getProductById(@RequestParam Integer productId) {
        final Logger logger = LoggerFactory.getLogger(ProductController.class);

        logger.info("Retrieving product by ID: {}", productId);

        ProductEntity product = this.productDao.getProductById(productId);

        if (product != null) {
            logger.info("Product ID: {}", product.getProductId());
            logger.info("Product Name: {}", product.getProductName());
            logger.info("Product Price: {}", product.getProductPrice());
            logger.info("Barcode: {}", product.getBarcode());
        } else {
            logger.info("Product with ID {} not found", productId);
        }

        return product;
    }
}
