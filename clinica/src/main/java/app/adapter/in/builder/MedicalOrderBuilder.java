package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.ClinicalOrderInputValidator;
import app.domain.model.MedicalOrder;

import java.time.LocalDate;

@Component
public class MedicalOrderBuilder {
    @Autowired
    private ClinicalOrderInputValidator orderValidator;

    public MedicalOrder build(String orderId, String patientId, String doctorId, LocalDate date) throws Exception {
        String validatedOrderId = orderValidator.validateOrderNumber(orderId);

        MedicalOrder medicalOrder = new MedicalOrder(
                validatedOrderId,
                patientId,
                doctorId,
                date
        );

        return medicalOrder;
    }
}