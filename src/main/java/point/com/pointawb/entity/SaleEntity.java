package point.com.pointawb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "sales")
@Data //Getter and Setter ...
@Entity
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_id")
    private Integer salesId;

    @Column(name = "product_id") // Foreign key
    private Integer productId;

    @Column(name = "order_id") // Foreign Key
    private Integer orderId;

    @JsonManagedReference // Serializable
    @OneToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false) // non update non insert
    private ProductEntity product ;

}

