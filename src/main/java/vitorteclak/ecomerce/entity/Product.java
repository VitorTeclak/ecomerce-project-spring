package vitorteclak.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT", name = "technical_specifications")
    private String technicalSpecifications;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(length = 50, nullable = false)
    private String category;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(length = 50, nullable = false)
    private String code;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Product(String name, String technicalSpecifications, String description, String category, BigDecimal price, String code){
        this.name = name;
        this.technicalSpecifications = technicalSpecifications;
        this.description = description;
        this.category = category;
        this.price = price;
        this.code = code;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    public Product(String name, String technicalSpecifications, String description, String category, BigDecimal price, String code, LocalDateTime updatedAt){
        this.name = name;
        this.technicalSpecifications = technicalSpecifications;
        this.description = description;
        this.category = category;
        this.price = price;
        this.code = code;
        this.updatedAt = updatedAt;
    }

}
