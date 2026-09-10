package vitorteclak.ecomerce.dto;

import lombok.Getter;
import lombok.Setter;
import vitorteclak.ecomerce.entity.Product;
import vitorteclak.ecomerce.entity.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDTO {

    private String name;
    private String technicalSpecifications;
    private String description;
    private String category;
    private BigDecimal price;
    private String code;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.technicalSpecifications = product.getTechnicalSpecifications();
        this.description = product.getDescription();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.code = product.getCode();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
    }
}
