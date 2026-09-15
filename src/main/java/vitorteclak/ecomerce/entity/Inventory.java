package vitorteclak.ecomerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name = "product_id")
    private Long productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Long quantity;

    @Column(name = "minimum_quantity", nullable = false)
    private Long minimumQuantity;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Inventory(Product product, Long quantity, Long minimumQuantity, LocalDateTime updatedAt) {
        this.product = product;
        this.quantity = quantity;
        this.minimumQuantity = minimumQuantity;
        this.updatedAt = updatedAt;
    }
}
