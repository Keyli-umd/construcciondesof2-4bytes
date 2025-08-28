package app.domain.ports;

import java.time.Year;

public interface BillingPort {
    String generateInvoice(String patientIdCard, String attendingDoctorIdCard) throws Exception;

    double calculateCopay(String patientIdCard, double totalCost, Year year) throws Exception;

    boolean hasExceededAnnualCopay(String patientIdCard, Year year) throws Exception;
}
