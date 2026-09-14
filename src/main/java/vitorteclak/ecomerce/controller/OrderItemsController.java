package vitorteclak.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vitorteclak.ecomerce.dto.OrderDTO;
import vitorteclak.ecomerce.dto.OrderItemsDTO;
import vitorteclak.ecomerce.dto.request.OrderItemsRequest;
import vitorteclak.ecomerce.service.OrderItemsService;

import java.util.List;

@RestController
@RequestMapping("orderItems")
public class OrderItemsController {
    @Autowired
    OrderItemsService orderItemsService;

    @PostMapping
    public String addOrderItems(@RequestBody OrderItemsRequest orderRequest){
        orderItemsService.addOrderItems(orderRequest);
        return "Product saved successfully";
    }

    @GetMapping
    public List<OrderItemsDTO> getAllOrders(){
        return orderItemsService.getAllOrders();
    }

    @GetMapping("/{id}")
    public List<OrderItemsDTO> getOrderById(@PathVariable("id") Long id){
        return orderItemsService.getOrderByOrderId(id);
    }
}

