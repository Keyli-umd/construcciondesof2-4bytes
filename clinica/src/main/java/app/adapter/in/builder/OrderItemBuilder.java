package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.adapter.in.validators.OrderItemInputValidator;
import app.domain.model.OrderItem;

@Component
public class OrderItemBuilder {

    @Autowired
    private OrderItemInputValidator validator;

    public OrderItem build(String itemNumber, String type, String referenceId) throws Exception {
        OrderItem item = new OrderItem();
        item.setItemNumber(validator.validateItemNumber(itemNumber));
        item.setType(validator.validateType(type));
        item.setReferenceId(validator.validateReferenceId(referenceId));
        return item;
    }
}