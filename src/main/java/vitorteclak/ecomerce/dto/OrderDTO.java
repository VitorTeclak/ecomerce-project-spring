package vitorteclak.ecomerce.dto;

import vitorteclak.ecomerce.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderDTO(
        Long orderId,
        Long userId,
        String userName,
        String paymentMethod,
        BigDecimal totalAmount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public OrderDTO(Order order) {
        this(
                order.getOrderId(),
                order.getUser().getId(),
                order.getUser().getName(),
                order.getPaymentMethod(),
                order.getTotalAmount(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
    }
}

