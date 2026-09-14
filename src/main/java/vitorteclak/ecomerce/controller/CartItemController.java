package vitorteclak.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitorteclak.ecomerce.dto.request.CartItemsRequest;
import vitorteclak.ecomerce.dto.request.OrderItemsRequest;
import vitorteclak.ecomerce.dto.request.RemoveItemCart;
import vitorteclak.ecomerce.repository.CartItemsRepository;
import vitorteclak.ecomerce.service.CartItemsService;

@RestController
@RequestMapping("cartItems")
public class CartItemController {

    @Autowired
    CartItemsService cartItemsService;

    @PostMapping("/addItem")
    public void addItemCart(@RequestBody CartItemsRequest CartItemsRequest){

        cartItemsService.addItemCart(CartItemsRequest);
    }

    @PostMapping("/removeOneItem")
    public void removeOneItemCart(@RequestBody RemoveItemCart removeOneItemCart){
        cartItemsService.removeOneItem(removeOneItemCart);
    }

    @PostMapping("/removeAllItem")
    public void removeAllItemCart(@RequestBody RemoveItemCart itemToRemove){
        cartItemsService.removeAllItems(itemToRemove);
    }

}
