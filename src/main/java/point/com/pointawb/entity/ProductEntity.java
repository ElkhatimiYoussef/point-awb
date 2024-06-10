package point.com.pointawb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "products")
@Data //Getter and Setter ...
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "barcode")
    private String barcode;

    @JsonBackReference // No Serializable  pour éviter les boucles infinies lors de la sérialisation d'objets avec des relations
    @OneToOne(mappedBy = "product") // prcq dans Sale je met product
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private SaleEntity sale ; // pour chaque salle je voulais avoire un details
}
