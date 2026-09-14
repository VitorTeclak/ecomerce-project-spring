package vitorteclak.ecomerce.dto;

import vitorteclak.ecomerce.entity.OrderItems;

import java.math.BigDecimal;

public record OrderItemsDTO(
        Long orderId,
        Long productId,
        String productName,
        Long quantity,
        BigDecimal unitPrice
) {
    public OrderItemsDTO(OrderItems order){
        this(
                order.getOrder().getOrderId(),
                order.getProduct().getProductId(),
                order.getProduct().getName(),
                order.getQuantity(),
                order.getProduct().getPrice()
        );
    }
}
