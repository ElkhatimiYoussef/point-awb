package point.com.pointawb.entity;

import lombok.Data;

import jakarta.persistence.*;

@Table(name = "orders")
@Data //Getter and Setter ...
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "total")
    private Double total;
}

