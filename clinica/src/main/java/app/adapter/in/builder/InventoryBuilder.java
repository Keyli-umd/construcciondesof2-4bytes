package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.InventoryItemInputValidator;
import app.domain.model.DiagnosticInventory;
import app.domain.model.MedicationInventory;
import app.domain.model.ProcedureInventory;

@Component
public class InventoryBuilder {
    @Autowired
    private InventoryItemInputValidator validator;

    public DiagnosticInventory buildDiagnostic(String id, String name, String type) throws Exception {
        String validatedId = validator.validateId(id);
        String validatedName = validator.validateName(name);
        String validatedType = validator.validateType(type);

        return new DiagnosticInventory(validatedId, validatedName, validatedType);
    }

    public MedicationInventory buildMedication(String id, String name, String type) throws Exception {
        String validatedId = validator.validateId(id);
        String validatedName = validator.validateName(name);
        String validatedType = validator.validateType(type);

        return new MedicationInventory(validatedId, validatedName, validatedType);
    }

    public ProcedureInventory buildProcedure(String id, String name, String type) throws Exception {
        String validatedId = validator.validateId(id);
        String validatedName = validator.validateName(name);
        String validatedType = validator.validateType(type);

        return new ProcedureInventory(validatedId, validatedName, validatedType);
    }
}
