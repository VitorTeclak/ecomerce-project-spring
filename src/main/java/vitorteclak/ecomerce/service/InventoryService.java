package vitorteclak.ecomerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vitorteclak.ecomerce.dto.request.InventoryItemRequest;
import vitorteclak.ecomerce.dto.request.UpdateQuantityInventoryRequest;
import vitorteclak.ecomerce.entity.Inventory;
import vitorteclak.ecomerce.entity.Product;
import vitorteclak.ecomerce.exceptions.NotFound;
import vitorteclak.ecomerce.repository.InventoryRepository;
import vitorteclak.ecomerce.repository.ProductRepository;

import java.time.LocalDateTime;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ProductRepository productRepository;

    public void addItemAtInventory(InventoryItemRequest item){
        Product product = productRepository.findById(item.productId())
                .orElseThrow(() -> new NotFound("Product", "Not Found"));
        Inventory inventory = new Inventory(
                product,
                item.quantity(),
                item.minimumQuantity(),
                LocalDateTime.now()
        );
        inventoryRepository.save(inventory);
    }
    public void updateAddQuantityItem(UpdateQuantityInventoryRequest request){
        Inventory inventory = inventoryRepository.findById(request.productId())
                .orElseThrow(() -> new NotFound("Product", "Not Found"));

        inventory.setQuantity(request.quantity() + inventory.getQuantity());
        inventory.setUpdatedAt(LocalDateTime.now());

        inventoryRepository.save(inventory);

    }
    public void updateRemoveQuantityItem(UpdateQuantityInventoryRequest request){
        Inventory inventory = inventoryRepository.findById(request.productId())
                .orElseThrow(() -> new NotFound("Product", "Not Found"));

        inventory.setQuantity(inventory.getQuantity() - request.quantity());
        inventory.setUpdatedAt(LocalDateTime.now());

        inventoryRepository.save(inventory);

    }
}
