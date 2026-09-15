package vitorteclak.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitorteclak.ecomerce.dto.request.InventoryItemRequest;
import vitorteclak.ecomerce.dto.request.UpdateQuantityInventoryRequest;
import vitorteclak.ecomerce.entity.Inventory;
import vitorteclak.ecomerce.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @PostMapping("/addItem")
    public String addItemAtInventory(@RequestBody InventoryItemRequest item){
        inventoryService.addItemAtInventory(item);
        return "Item successfully added";
    }

    @PostMapping("/updateAddQuantity")
    public String updateAddQuantityItem(@RequestBody UpdateQuantityInventoryRequest request){
        inventoryService.updateAddQuantityItem(request);
        return "Item successfully updated";
    }

    @PostMapping("/updateRemoveQuantity")
    public String updateRemoveQuantityItem(@RequestBody UpdateQuantityInventoryRequest request){
        inventoryService.updateRemoveQuantityItem(request);
        return "Item successfully updated";
    }
}
