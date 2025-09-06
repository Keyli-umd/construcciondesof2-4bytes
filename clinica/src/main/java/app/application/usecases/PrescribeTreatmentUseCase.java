// PrescribeTreatmentUseCase.java
package app.application.usecases;
import app.domain.services.DoctorService;
public class PrescribeTreatmentUseCase {
    private final DoctorService doctorService;

    public PrescribeTreatmentUseCase(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public void execute(String patientId, String medication) {
        doctorService.prescribeTreatment(patientId, medication);
    }
}
