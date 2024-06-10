package point.com.pointawb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import point.com.pointawb.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
   ProductEntity findByBarcode(String barcode);
}
