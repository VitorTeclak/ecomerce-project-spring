package vitorteclak.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitorteclak.ecomerce.dto.OrderDTO;
import vitorteclak.ecomerce.dto.OrderItemsDTO;
import vitorteclak.ecomerce.dto.request.OrderItemRequest;
import vitorteclak.ecomerce.dto.request.OrderItemsRequest;
import vitorteclak.ecomerce.entity.Order;
import vitorteclak.ecomerce.entity.OrderItems;
import vitorteclak.ecomerce.entity.Product;
import vitorteclak.ecomerce.exceptions.NotFound;
import vitorteclak.ecomerce.repository.OrderItemsRepository;
import vitorteclak.ecomerce.repository.OrderRepository;
import vitorteclak.ecomerce.repository.ProductRepository;

import java.util.List;

@Service
public class OrderItemsService {
    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    public void addOrderItems(OrderItemsRequest request) {
        Order order = orderRepository.findById(request.orderId())
                .orElseThrow(() -> new NotFound("Order", "Not Found"));
        for (OrderItemRequest item : request.items()) {
            Product product = productRepository.findById(item.productId())
                    .orElseThrow(() -> new NotFound("Product", "Not Found"));
            OrderItems orderItem = new OrderItems(
                    order,
                    product,
                    item.quantity(),
                    product.getPrice()
            );
            orderItemsRepository.save(orderItem);
        }
    }

    public List<OrderItemsDTO> getAllOrders(){
        return orderItemsRepository.findAll()
                .stream()
                .map(OrderItemsDTO::new)
                .toList();
    }
    public List<OrderItemsDTO> getOrderByOrderId(Long id) {
        List<OrderItems> orderItems = orderItemsRepository.findByOrder_OrderId(id);
        if (orderItems.isEmpty()) {
            throw new NotFound("Order", "Not Found");
        }
        return orderItems.stream()
                .map(OrderItemsDTO::new)
                .toList();
    }
}
