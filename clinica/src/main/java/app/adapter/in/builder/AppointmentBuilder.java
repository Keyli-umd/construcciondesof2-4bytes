package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.AppointmentInputValidator;
import app.domain.model.Appointment;

import java.time.LocalDateTime;

@Component
public class AppointmentBuilder {
    @Autowired
    private AppointmentInputValidator appointmentValidator;

    public Appointment build(String patientId, String doctorId, String dateTime, String reason) throws Exception {
        String validatedReason = appointmentValidator.validateReason(reason);
        long validatedPatientId = appointmentValidator.validatePatientId(patientId);
        long validatedDoctorId = appointmentValidator.validateDoctorId(doctorId);
        LocalDateTime validatedDateTime = appointmentValidator.validateDateTime(dateTime);

        Appointment appointment = new Appointment(
                String.valueOf(validatedPatientId),
                String.valueOf(validatedDoctorId),
                validatedDateTime
        );

        return appointment;
    }
}