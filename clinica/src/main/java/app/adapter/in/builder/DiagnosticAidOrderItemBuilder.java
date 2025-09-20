package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.adapter.in.validators.DiagnosticAidOrderItemInputValidator;
import app.domain.model.DiagnosticAidOrderItem;

@Component
public class DiagnosticAidOrderItemBuilder {

    @Autowired
    private DiagnosticAidOrderItemInputValidator validator;

    public DiagnosticAidOrderItem build(String id, String itemNumber, String name, String resultAvailable) throws Exception {
        DiagnosticAidOrderItem item = new DiagnosticAidOrderItem();
        item.setId(validator.validateId(id));
        item.setItemNumber(validator.validateItemNumber(itemNumber));
        item.setName(validator.validateName(name));
        item.setResultAvailable(validator.validateResultAvailable(resultAvailable));
        return item;
    }
}