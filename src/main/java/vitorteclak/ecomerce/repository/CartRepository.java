package vitorteclak.ecomerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vitorteclak.ecomerce.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
