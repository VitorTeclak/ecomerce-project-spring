package vitorteclak.ecomerce.dto.request;

public record UpdateQuantityInventoryRequest(
        Long productId,
        Long quantity
)
{}
