package app.application.usecases;

import app.domain.model.Patient;
import app.domain.model.Invoice;
import app.domain.services.AdministrativeStaffService;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AdministrativeUseCase {

    private final AdministrativeStaffService adminService;

    public AdministrativeUseCase(AdministrativeStaffService adminService) {
        this.adminService = adminService;
    }

    // Caso de uso: Crear paciente
    public void createPatient(Patient patient) {
        try {
            adminService.createPatient(patient);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al crear paciente -> " + e.getMessage());
        }
    }

    // Caso de uso: Actualizar datos del paciente
    public void updatePatient(String idCard, String newAddress, String newPhone) {
        try {
            adminService.updatePatient(idCard, newAddress, newPhone);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al actualizar paciente -> " + e.getMessage());
        }
    }

    // Caso de uso: Crear cita médica
    public void createAppointment(String patientId, String doctorId, LocalDateTime dateTime) {
        try {
            adminService.createAppointment(patientId, doctorId, dateTime);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al crear cita -> " + e.getMessage());
        }
    }

    // Caso de uso: Crear factura
    public Invoice createInvoice(Patient patient, String doctorName, String insuranceCompany, String policyNumber,
    long policyDaysLeft, LocalDate policyEndDate, double totalCost) {
        try {
            return adminService.createInvoice(patient, doctorName, insuranceCompany,
                                              policyNumber, policyDaysLeft, policyEndDate, totalCost);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al crear factura -> " + e.getMessage());
        }
    }
}
