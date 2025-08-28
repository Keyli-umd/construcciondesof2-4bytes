package app.domain.services;

import app.domain.model.Appointment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdministrativeStaffService {

    private final List<Appointment> appointments;

    public AdministrativeStaffService() {
        this.appointments = new ArrayList<>();
    }

    // Programar una cita
    public void scheduleAppointment(String patientId, String doctorId, LocalDateTime dateTime) {
        Appointment appointment = new Appointment(patientId, doctorId, dateTime);
        appointments.add(appointment);
        System.out.println("Cita programada: " + appointment);
    }

    // Consultar todas las citas
    public List<Appointment> listAppointments() {
        return new ArrayList<>(appointments);
    }

    // Cancelar cita
    public boolean cancelAppointment(String patientId, LocalDateTime dateTime) {
        return appointments.removeIf(a -> a.getPatientId().equals(patientId) && a.getDateTime().equals(dateTime));
    }
        public Object getMedicalHistory(String patientId) {
        throw new UnsupportedOperationException(
            "El staff administrativo no puede aceder a la historia clinica"
        );
       }
}
