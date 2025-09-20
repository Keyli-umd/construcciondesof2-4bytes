package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.adapter.in.validators.MedicationOrderItemInputValidator;
import app.domain.model.MedicationOrderItem;

@Component
public class MedicationOrderItemBuilder {

    @Autowired
    private MedicationOrderItemInputValidator validator;

    public MedicationOrderItem build(String id, String dose, String durationDays, String itemNumber) throws Exception {
        MedicationOrderItem item = new MedicationOrderItem();
        item.setId(validator.validateId(id));
        item.setDose(validator.validateDose(dose));
        item.setDurationDays(validator.validateDurationDays(durationDays));
        item.setItemNumber(validator.validateItemNumber(itemNumber));
        return item;
    }
}