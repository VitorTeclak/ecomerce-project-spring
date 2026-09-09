package vitorteclak.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vitorteclak.ecomerce.dto.UserDTO;
import vitorteclak.ecomerce.entity.User;
import vitorteclak.ecomerce.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers(){ return userService.getAllUsers(); }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("detail/{id}")
    public User getDetailsByUser(@PathVariable("id") Long id){
        return userService.getDetailsByUser(id);
    }

    @PutMapping("{id}")
    public String editUser(@PathVariable("id") Long id, @RequestBody User user){
        userService.editUser(id, user);
        return  "User successfully updated";
    }

    @DeleteMapping("{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "User successfully deleted";
    }
}
