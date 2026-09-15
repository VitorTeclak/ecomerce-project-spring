package vitorteclak.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitorteclak.ecomerce.entity.Inventory;

public interface InventoryRepository extends JpaRepository <Inventory, Long> {
}
