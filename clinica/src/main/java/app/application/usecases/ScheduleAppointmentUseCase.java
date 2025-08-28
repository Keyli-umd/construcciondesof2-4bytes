package app.application.usecases;

import app.domain.services.AdministrativeStaffService;
import java.time.LocalDateTime;

public class ScheduleAppointmentUseCase {
    private final AdministrativeStaffService staffService;

    public ScheduleAppointmentUseCase(AdministrativeStaffService staffService) {
        this.staffService = staffService;
    }

    public void execute(String patientId, String doctorId, LocalDateTime dateTime) {
        staffService.scheduleAppointment(patientId, doctorId, dateTime);
    }
}
