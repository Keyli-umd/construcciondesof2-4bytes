package app.api.dto;

import jakarta.validation.constraints.*;
import app.api.validation.HorarioAtencion;

import java.time.LocalDateTime;

public class CitaCrearDTO {

    @NotNull(message = "El ID del paciente es obligatorio")
    private Long pacienteId;

    @NotNull(message = "El ID del médico es obligatorio")
    private Long medicoId;

    @NotNull(message = "La fecha/hora es obligatoria")
    @Future(message = "La cita debe ser a futuro")
    @HorarioAtencion
    private LocalDateTime fechaHora;

    @NotBlank(message = "El motivo es obligatorio")
    @Size(max = 200, message = "El motivo no debe superar 200 caracteres")
    private String motivo;

    // Getters y setters
    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }

    public Long getMedicoId() { return medicoId; }
    public void setMedicoId(Long medicoId) { this.medicoId = medicoId; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}
