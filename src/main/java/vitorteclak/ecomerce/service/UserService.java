package vitorteclak.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitorteclak.ecomerce.dto.UserDTO;
import vitorteclak.ecomerce.entity.User;
import vitorteclak.ecomerce.exceptions.NotFound;
import vitorteclak.ecomerce.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .toList();
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFound("User", "Not Found"));
        return new UserDTO(user);
    }
    public User getDetailsByUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFound("User", "Not Found"));
        return user;
    }
    public void editUser(Long id, User user){
        user.setId(id);
        userRepository.save(user);
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
