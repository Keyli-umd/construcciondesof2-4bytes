// GenerateInvoiceUseCase.java
package app.application.usecases;
import app.domain.services.BillingService;
public class GenerateInvoiceUseCase {
    private final BillingService billingService;

    public GenerateInvoiceUseCase(BillingService billingService) {
        this.billingService = billingService;
    }

    public void execute(String patientId, double amount) {
        billingService.generateInvoice(patientId, amount);
    }
}
