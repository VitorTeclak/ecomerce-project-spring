package vitorteclak.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@IdClass(CartItemsId.class)
@Table(name = "cart_items")
public class CartItems {

    @Id
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Long quantity;

    public CartItems(Cart cart, Product product, Long quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }
}
