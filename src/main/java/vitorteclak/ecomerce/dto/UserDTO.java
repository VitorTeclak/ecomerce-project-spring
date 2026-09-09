package vitorteclak.ecomerce.dto;

import lombok.Getter;
import lombok.Setter;
import vitorteclak.ecomerce.entity.User;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String email;
    private String phone;
    private LocalDateTime createdAt;

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.createdAt = user.getCreatedAt();
    }
}
