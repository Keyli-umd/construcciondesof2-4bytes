// UpdateInventoryUseCase.java
package app.application.usecases;

import app.domain.services.NurseService;
public class UpdateInventoryUseCase {
    private final NurseService nurseService;

    public UpdateInventoryUseCase(NurseService nurseService) {
        this.nurseService = nurseService;
    }

    public void execute(String patientId, String vitals) {
        nurseService.updateVitalSigns(patientId, vitals);
    }
}
