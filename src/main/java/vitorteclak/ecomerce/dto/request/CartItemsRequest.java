package vitorteclak.ecomerce.dto.request;

import java.time.LocalDateTime;

public record CartItemsRequest (
        Long cartId,
        Long productId,
        Long quantity
)
{}
