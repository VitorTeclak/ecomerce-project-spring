package vitorteclak.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitorteclak.ecomerce.entity.OrderItems;
import vitorteclak.ecomerce.entity.OrderItemsId;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItems, OrderItemsId> {
    List<OrderItems> findByOrder_OrderId(Long orderId);
}
