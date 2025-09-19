package app.application.usecases;

import java.time.LocalDateTime;

import app.domain.ports.DoctorPort;
import app.domain.ports.MedicalHistoryPort;
import app.domain.ports.PatientPort;
import app.domain.services.DoctorServices;

public class DoctorUseCase {

    private final DoctorServices doctorServices;

    public DoctorUseCase(DoctorServices doctorServices) {
        this.doctorServices = doctorServices;
    }

    // Caso de uso: Crear orden médica
    public String createOrder(DoctorPort doctorPort, String patientIdCard, String doctorIdCard,
    LocalDateTime createdAt, String type) {
        try {
            doctorServices.CreateOrder(doctorPort);
            return doctorServices.execute(patientIdCard, doctorIdCard, createdAt, type);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al crear orden -> " + e.getMessage());
        }
    }

    // Caso de uso: Actualizar historia clínica
    public void updateMedicalHistory(MedicalHistoryPort medicalHistoryPort, String recordId, String doctorIdCard, 
    LocalDateTime updatedAt, String updatedDiagnosis, String updatedTreatment) {
        try {
            doctorServices.UpdateMedicalHistory(medicalHistoryPort);
            doctorServices.execute(recordId, doctorIdCard, updatedAt, updatedDiagnosis, updatedTreatment);
        } catch (UnsupportedOperationException e) {
            throw new RuntimeException("Throw exception: Funcionalidad no implementada aún -> " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al actualizar historia clínica -> " + e.getMessage());
        }
    }

    // Caso de uso: Crear historia clínica
    public String createMedicalHistory(MedicalHistoryPort medicalHistoryPort, String patientIdCard, String doctorIdCard, 
    LocalDateTime dateTime, String reason, String symptoms, String diagnosis) {
        try {
            doctorServices.CreateMedicalHistory(medicalHistoryPort);
            return doctorServices.execute(patientIdCard, doctorIdCard, dateTime, reason, symptoms, diagnosis);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al crear historia clínica -> " + e.getMessage());
        }
    }

    // Caso de uso: Buscar paciente
    public String findPatient(PatientPort patientPort, String idCard) {
        try {
            doctorServices.FindPatient(patientPort);
            return doctorServices.execute(idCard);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al buscar paciente -> " + e.getMessage());
        }
    }
}
