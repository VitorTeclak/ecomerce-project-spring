package vitorteclak.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitorteclak.ecomerce.dto.ProductDTO;
import vitorteclak.ecomerce.dto.UserDTO;
import vitorteclak.ecomerce.entity.Product;
import vitorteclak.ecomerce.entity.User;
import vitorteclak.ecomerce.exceptions.NotFound;
import vitorteclak.ecomerce.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.save(product);
    }
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTO::new)
                .toList();
    }
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFound("Product", "Not Found"));
        return new ProductDTO(product);
    }
    public Product getDetailsByProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFound("Product", "Not Found"));
        return product;
    }
    public void editProduct(Long id, Product product){
        product.setProductId(id);
        productRepository.save(product);
    }
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}
