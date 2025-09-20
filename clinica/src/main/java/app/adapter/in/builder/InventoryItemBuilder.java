package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.adapter.in.validators.InventoryItemInputValidator;
import app.domain.model.InventoryItem;

@Component
public class InventoryItemBuilder {

    @Autowired
    private InventoryItemInputValidator validator;

    public InventoryItem build(String id, String name, String type) throws Exception {
        InventoryItem item = new InventoryItem();
        item.setId(validator.validateId(id));
        item.setName(validator.validateName(name));
        item.setType(validator.validateType(type));
        return item;
    }
}