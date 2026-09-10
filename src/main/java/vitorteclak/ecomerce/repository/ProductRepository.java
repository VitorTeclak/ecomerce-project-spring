package vitorteclak.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitorteclak.ecomerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
