package vitorteclak.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitorteclak.ecomerce.dto.request.CartItemsRequest;
import vitorteclak.ecomerce.dto.request.RemoveItemCart;
import vitorteclak.ecomerce.entity.Cart;
import vitorteclak.ecomerce.entity.CartItems;
import vitorteclak.ecomerce.entity.Order;
import vitorteclak.ecomerce.entity.Product;
import vitorteclak.ecomerce.exceptions.NotFound;
import vitorteclak.ecomerce.repository.CartItemsRepository;
import vitorteclak.ecomerce.repository.CartRepository;
import vitorteclak.ecomerce.repository.ProductRepository;

import java.util.Optional;

@Service
public class CartItemsService {
    @Autowired
    CartItemsRepository cartItemsRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;


    public void addItemCart(CartItemsRequest request) {
        Cart cart = cartRepository.findById(request.cartId())
                .orElseThrow(() -> new NotFound("Cart", "Not Found"));
        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new NotFound("Product", "Not Found"));
        Optional<CartItems> existingItem = cartItemsRepository
                .findByCartAndProduct(cart, product);

        if (existingItem.isPresent()) {
            CartItems cartItem = existingItem.get();
            cartItem.setQuantity(
                    cartItem.getQuantity() + request.quantity()
            );
            cartItemsRepository.save(cartItem);
        } else {
            CartItems cartItem = new CartItems(
                    cart,
                    product,
                    request.quantity()
            );
            cartItemsRepository.save(cartItem);
        }
    }
    public void removeOneItem(RemoveItemCart request){
        Cart cart = cartRepository.findById(request.cartId())
                .orElseThrow(() -> new NotFound("Cart", "Not Found"));
        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new NotFound("Product", "Not Found"));
        Optional<CartItems> existingItem = cartItemsRepository
                .findByCartAndProduct(cart, product);

        if (existingItem.isPresent()) {

            CartItems cartItem = existingItem.get();

            if (cartItem.getQuantity() == 1) {
                cartItemsRepository.delete(cartItem);
            } else {
                cartItem.setQuantity(cartItem.getQuantity() - 1);
                cartItemsRepository.save(cartItem);
            }
        }
    }
    public void removeAllItems(RemoveItemCart request){
        Cart cart = cartRepository.findById(request.cartId())
                .orElseThrow(() -> new NotFound("Cart", "Not Found"));
        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new NotFound("Product", "Not Found"));
        Optional<CartItems> existingItem = cartItemsRepository
                .findByCartAndProduct(cart, product);
        existingItem.ifPresent(cartItem -> cartItemsRepository.delete(cartItem));
    }
}
