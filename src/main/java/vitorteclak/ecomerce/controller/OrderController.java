package vitorteclak.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vitorteclak.ecomerce.dto.OrderDTO;
import vitorteclak.ecomerce.dto.OrderRequest;
import vitorteclak.ecomerce.dto.UpdateStatusUpdateRequest;
import vitorteclak.ecomerce.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public String addOrder(@RequestBody OrderRequest request){
        orderService.createOrder(request);
        return "Order saved successfully";
    }

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderByOrderId(@PathVariable("id") Long id){
        return orderService.getOrderByOrderId(id);
    }

    @GetMapping("/user/{id}")
    public List<OrderDTO> getOrderByUserId(@PathVariable("id") Long id){
        return orderService.getOrderByUserId(id);
    }
    @PostMapping("{id}")
    public String updateOrderStatus(@PathVariable Long id, @RequestBody UpdateStatusUpdateRequest request){
        orderService.updateStatusOrder(id, request.status());
        return "Status successfully updated";
    }
}
