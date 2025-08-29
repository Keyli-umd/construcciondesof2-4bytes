package app.domain.services;

import app.domain.ports.PatientPort;

public class PatientService {
    private final PatientPort patientPort;

    public PatientService(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    // Verificar si un paciente existe por su cédula
    public boolean existsByIdCard(String idCard) {
        try {
            String id = patientPort.findIdByIdCard(idCard);
            return id != null && !id.isEmpty();
        } catch (Exception e) {
            return false; // si lanza excepción asumimos que no existe
        }
    }

    // Actualizar datos de contacto de un paciente
    public void updatePatientContact(String idCard, String address, String phone, String email) throws Exception {
        patientPort.updateContact(idCard, address, phone, email);
    }
}
