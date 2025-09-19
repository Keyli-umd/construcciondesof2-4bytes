package app.domain.model;

import java.time.LocalDate;

public class Invoice {
    private String patientName;
    private int patientAge;
    private String patientId;
    private String doctorName;
    private String insuranceCompany;
    private String policyNumber;
    private long policyDaysLeft;
    private LocalDate policyEndDate;
    private double totalCost;

    public Invoice(String patientName, int patientAge, String patientId,
                   String doctorName, String insuranceCompany, String policyNumber,
                   long policyDaysLeft, LocalDate policyEndDate, double totalCost) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.insuranceCompany = insuranceCompany;
        this.policyNumber = policyNumber;
        this.policyDaysLeft = policyDaysLeft;
        this.policyEndDate = policyEndDate;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "Nombre del paciente ='" + patientName + '\'' +
                ", Edad=" + patientAge +
                ", Id='" + patientId + '\'' +
                ", Nombre del doctor='" + doctorName + '\'' +
                ", Compañia de seguros='" + insuranceCompany + '\'' +
                ", Numero de poliza='" + policyNumber + '\'' +
                ", Dias restantes de la poliza=" + policyDaysLeft +
                ", Fecha de vencimiento poliza=" + policyEndDate +
                ", Costo Total=" + totalCost +
                '}';
    }
}


