package vitorteclak.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitorteclak.ecomerce.dto.OrderDTO;
import vitorteclak.ecomerce.dto.request.OrderRequest;
import vitorteclak.ecomerce.entity.Order;
import vitorteclak.ecomerce.entity.User;
import vitorteclak.ecomerce.exceptions.NotFound;
import vitorteclak.ecomerce.repository.OrderRepository;
import vitorteclak.ecomerce.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    public void createOrder(OrderRequest request){

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new NotFound("User", "Not Found"));
        Order order = new Order(
                user,
                request.paymentMethod(),
                request.totalAmount()
        );

        orderRepository.save(order);
    }
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderDTO::new)
                .toList();
    }
    public OrderDTO getOrderByOrderId(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFound("Order", "Not Found"));
        return new OrderDTO(order);
    }

    public List<OrderDTO> getOrderByUserId(Long id) {

        List<Order> orders = orderRepository.findByUserId(id);

        if (orders.isEmpty()) {
            throw new NotFound("Order", "Not Found");
        }

        return orders.stream()
                .map(OrderDTO::new)
                .toList();
    }
    public void updateStatusOrder(Long id, String status){
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new NotFound("Order", "Not Found"));

        existingOrder.setStatus(status);
        existingOrder.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(existingOrder);
    }

}
