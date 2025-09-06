package app.api.dto;

import jakarta.validation.constraints.*;
import app.api.validation.DocumentoCol;
import app.api.validation.TelefonoCo;

import java.time.LocalDate;

public class PacienteDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 60, message = "El nombre no debe superar 60 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 60, message = "El apellido no debe superar 60 caracteres")
    private String apellido;

    @NotBlank(message = "El documento es obligatorio")
    @DocumentoCol(message = "Documento inválido: use solo dígitos (8–10)")
    private String documento;

    @Email(message = "El correo no es válido")
    @Size(max = 120, message = "El correo no debe superar 120 caracteres")
    private String email;

    @NotBlank(message = "El teléfono es obligatorio")
    @TelefonoCo(message = "Teléfono inválido")
    private String telefono;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}
