package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.adapter.in.validators.ClinicalOrderInputValidator;
import app.domain.model.ClinicalOrder;
import app.domain.model.OrderItem;

import java.util.List;

@Component
public class ClinicalOrderBuilder {

    @Autowired
    private ClinicalOrderInputValidator orderValidator;

    public ClinicalOrder build(String orderNumber, List<OrderItem> items) throws Exception {
        ClinicalOrder order = new ClinicalOrder();
        order.setOrderNumber(orderValidator.validateOrderNumber(orderNumber));
        orderValidator.validateItems(items);
        order.setItems(items);
        return order;
    }
}