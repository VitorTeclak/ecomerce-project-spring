package vitorteclak.ecomerce.dto.request;

import java.util.List;

public record OrderItemsRequest(
        Long orderId,
        List<OrderItemRequest> items
) {}
