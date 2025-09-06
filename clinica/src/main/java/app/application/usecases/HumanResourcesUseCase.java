package app.application.usecases;

import app.domain.model.User;
import app.domain.services.HRService;

import java.util.List;

public class HumanResourcesUseCase {

    private final HRService hrService;

    public HumanResourcesUseCase(HRService hrService) {
        this.hrService = hrService;
    }

    // Caso de uso: Crear usuario
    public void createUser(User user) {
        try {
            hrService.createUser(user);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al crear usuario -> " + e.getMessage());
        }
    }

    // Caso de uso: Actualizar usuario
    public void updateUser(String idNumber, User updatedUser) {
        try {
            hrService.updateUser(idNumber, updatedUser);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al actualizar usuario -> " + e.getMessage());
        }
    }

    // Caso de uso: Eliminar usuario
    public void deleteUser(String idNumber) {
        try {
            hrService.deleteUser(idNumber);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al eliminar usuario -> " + e.getMessage());
        }
    }

    // Caso de uso: Buscar usuario por cédula
    public User getUserById(String idNumber) {
        try {
            return hrService.getUserById(idNumber);
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al buscar usuario -> " + e.getMessage());
        }
    }

    // Caso de uso: Listar todos los usuarios
    public List<User> getAllUsers() {
        try {
            return hrService.getAllUsers();
        } catch (Exception e) {
            throw new RuntimeException("Throw exception: Error al listar usuarios -> " + e.getMessage());
        }
    }
}
