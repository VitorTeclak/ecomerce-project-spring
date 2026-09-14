package vitorteclak.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitorteclak.ecomerce.entity.Cart;
import vitorteclak.ecomerce.entity.CartItems;
import vitorteclak.ecomerce.entity.CartItemsId;
import vitorteclak.ecomerce.entity.Product;


import java.util.List;
import java.util.Optional;

public interface CartItemsRepository extends JpaRepository<CartItems, CartItemsId> {
    List<CartItems> findByCart_CartId(Long cartId);
    Optional<CartItems> findByCartAndProduct(Cart cart, Product product);
}
