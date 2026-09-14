package vitorteclak.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitorteclak.ecomerce.entity.Cart;
import vitorteclak.ecomerce.entity.User;
import vitorteclak.ecomerce.repository.CartRepository;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;


    public void createCart(User user){
        Cart cart = new Cart( user );
        cartRepository.save(cart);
    }



}
