package point.com.pointawb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import point.com.pointawb.entity.ProductEntity;
import point.com.pointawb.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDao {

    @Autowired
    private ProductRepo productRepo;

    public ProductEntity addProduct(ProductEntity productEntity){
        ProductEntity savedProduct = productRepo.save(productEntity);
        return savedProduct;
    }

    /*
       public Iterable<ProductDocument> getAllProductDoc() { // elasticsearch
       return productDocumentRepo.findAll();
       }
    */

    public ProductEntity updateProduct(ProductEntity productEntity){
        return this.productRepo.save(productEntity);
    }

    public void deleteProduct(Integer productId) {
        this.productRepo.deleteById(productId);
   }

   //List of product
   public List<ProductEntity> getAllProducts() {
        return productRepo.findAll();
   }

    public ProductEntity getProductByBarcode(String barcode) {
        Optional<ProductEntity> o = Optional.ofNullable(this.productRepo.findByBarcode(barcode));
        return o.isPresent() ? o.get() : null;
    }

    public ProductEntity getProductById(Integer productId) {
        Optional<ProductEntity> o = this.productRepo.findById(productId);
        return o.isPresent() ? o.get() : null;
    }

}
