package vitorteclak.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import vitorteclak.ecomerce.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
}
