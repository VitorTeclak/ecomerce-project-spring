package vitorteclak.ecomerce.dto.request;

import java.math.BigDecimal;

public record OrderRequest(
        Long userId,
        String status,
        String paymentMethod,
        BigDecimal totalAmount
) {}
