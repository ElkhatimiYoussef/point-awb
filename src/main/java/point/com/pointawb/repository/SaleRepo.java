package point.com.pointawb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import point.com.pointawb.entity.SaleEntity;

import java.util.List;

public interface SaleRepo extends JpaRepository<SaleEntity, Integer> {

    List<SaleEntity> findAllByOrderId(Integer orderId);

}
