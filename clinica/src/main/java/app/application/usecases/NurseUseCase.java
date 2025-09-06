package app.application.usecases;

import app.domain.model.Patient;
import app.domain.model.Visit;
import app.domain.model.MedicalOrder;
import app.domain.services.NurseService;

public class NurseUseCase {

    private final NurseService nurseService;

    public NurseUseCase(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    // Caso de uso: Registrar visita de un paciente
    public void registerVisit(String patientId, Visit visit) {
        try {
            nurseService.registerVisit(patientId, visit);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al registrar visita -> " + e.getMessage());
        }
    }

    // Caso de uso: Buscar orden médica
    public MedicalOrder findOrder(String orderId) {
        try {
            return nurseService.findOrder(orderId);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al buscar orden médica -> " + e.getMessage());
        }
    }

    // Caso de uso: Buscar paciente
    public Patient findPatient(String patientId) {
        try {
            return nurseService.findPatient(patientId);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al buscar paciente -> " + e.getMessage());
        }
    }
}
