package app.adapter.out.memory;

import app.domain.ports.BillingPort;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class InMemoryBillingPort implements BillingPort {

    private final Map<String, Double> copayAccumulated = new HashMap<>();

    @Override
    public String generateInvoice(String patientIdCard, String attendingDoctorIdCard) throws Exception {
        return "INV-" + patientIdCard + "-" + attendingDoctorIdCard + "-" + System.currentTimeMillis();
    }

    @Override
    public double calculateCopay(String patientIdCard, double totalCost, Year year) throws Exception {
        double copay = 50000; // regla: copago fijo
        double accumulated = copayAccumulated.getOrDefault(patientIdCard + "-" + year, 0.0);

        if (accumulated >= 1_000_000) {
            return 0; // ya alcanzó el tope
        }

        accumulated += copay;
        copayAccumulated.put(patientIdCard + "-" + year, accumulated);
        return copay;
    }

    @Override
    public boolean hasExceededAnnualCopay(String patientIdCard, Year year) throws Exception {
        return copayAccumulated.getOrDefault(patientIdCard + "-" + year, 0.0) >= 1_000_000;
    }
}
