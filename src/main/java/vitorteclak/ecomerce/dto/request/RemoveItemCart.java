package vitorteclak.ecomerce.dto.request;

public record RemoveItemCart(
        Long cartId,
        Long productId
) {
}
