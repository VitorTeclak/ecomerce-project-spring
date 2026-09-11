package vitorteclak.ecomerce.dto;

import java.math.BigDecimal;

public record OrderRequest(
        Long userId,
        String status,
        String paymentMethod,
        BigDecimal totalAmount
) {}
