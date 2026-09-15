package vitorteclak.ecomerce.dto.request;

public record InventoryItemRequest (
        Long productId,
        Long quantity,
        Long minimumQuantity
)
{}
