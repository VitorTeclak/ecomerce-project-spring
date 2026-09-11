package vitorteclak.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitorteclak.ecomerce.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);
}
