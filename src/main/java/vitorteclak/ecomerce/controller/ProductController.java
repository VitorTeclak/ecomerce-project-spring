package vitorteclak.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vitorteclak.ecomerce.dto.ProductDTO;
import vitorteclak.ecomerce.dto.UserDTO;
import vitorteclak.ecomerce.entity.Product;
import vitorteclak.ecomerce.entity.User;
import vitorteclak.ecomerce.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public String addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "Product saved successfully";
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() { return productService.getAllProducts(); }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping("detail/{id}")
    public Product getDetailsByProduct(@PathVariable("id") Long id){
        return productService.getDetailsByProduct(id);
    }

    @PutMapping("{id}")
    public String editProduct(@PathVariable("id") Long id, @RequestBody Product product){
        productService.editProduct(id, product);
        return  "Product successfully updated";
    }

    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return "Product successfully deleted";
    }
}
