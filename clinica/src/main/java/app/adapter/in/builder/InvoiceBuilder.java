package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.InvoiceInputValidator;
import app.domain.model.Invoice;

import java.time.LocalDate;

@Component
public class InvoiceBuilder {
    @Autowired
    private InvoiceInputValidator invoiceValidator;

    public Invoice build(
            String patientName,
            String patientAge,
            String patientId,
            String doctorName,
            String insuranceCompany,
            String policyNumber,
            String policyDaysLeft,
            LocalDate policyEndDate,
            String totalCost
    ) throws Exception {
        int validatedAge = Integer.parseInt(patientAge);
        long validatedDaysLeft = Long.parseLong(policyDaysLeft);
        String validatedPolicyNumber = invoiceValidator.validatePolicyNumber(policyNumber);
        double validatedTotalCost = invoiceValidator.validateAmount(totalCost);

        Invoice invoice = new Invoice(
                patientName,
                validatedAge,
                patientId,
                doctorName,
                insuranceCompany,
                validatedPolicyNumber,
                validatedDaysLeft,
                policyEndDate,
                validatedTotalCost
        );

        return invoice;
    }
}
