package app.application.usecases;


import app.domain.services.PatientService;

public class RegisterPatientUseCase {
    private final PatientService patientService;

    public RegisterPatientUseCase(PatientService patientService) {
        this.patientService = patientService;
    }

    // Verificar si un paciente existe por cédula
    public boolean patientExists(String idCard) {
        return patientService.existsByIdCard(idCard);
    }

    // Actualizar contacto de paciente
    public void updateContact(String idCard, String address, String phone, String email) throws Exception {
        patientService.updatePatientContact(idCard, address, phone, email);
    }
}
