package app.domain.services;

import app.domain.model.Employee;
import app.domain.model.enums.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HRService {
    private final List<Employee> employees;

    public HRService() {
        this.employees = new ArrayList<>();
    }

    // Crear un nuevo empleado
    public void createEmployee(Employee employee) {
        // Validación de unicidad de cédula
        Optional<Employee> exists = employees.stream()
                .filter(e -> e.getIdCard().equals(employee.getIdCard()))
                .findFirst();
        if (exists.isPresent()) {
            throw new IllegalArgumentException("Ya existe un empleado con dicha id");
        }
        employees.add(employee);
        System.out.println("Empleado creado: " + employee);
    }

    // Eliminar empleado
    public boolean deleteEmployee(String idCard) {
        return employees.removeIf(e -> e.getIdCard().equals(idCard));
    }

    // Asignar o actualizar rol
    public void updateRole(String idCard, Role newRole) {
        employees.stream()
                .filter(e -> e.getIdCard().equals(idCard))
                .findFirst()
                .ifPresentOrElse(
                        e -> {
                            e.setRole(newRole);
                            System.out.println("Rol actualizado: " + e);
                        },
                        () -> { throw new IllegalArgumentException("Empleado no encontrado"); }
                );
    }

    // Listar empleados
    public List<Employee> listEmployees() {
        return new ArrayList<>(employees);
    }
        public Object getPatientInfo(String id) {
        throw new UnsupportedOperationException(
            "Recursos Humanos no puede acceder a esta informacion"
        );
        }
}
