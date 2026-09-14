package vitorteclak.ecomerce.dto.request;

import java.time.LocalDateTime;

public record CartRequest (
    Long cartId,
    Long userId,
    LocalDateTime createdAt
)
{}
