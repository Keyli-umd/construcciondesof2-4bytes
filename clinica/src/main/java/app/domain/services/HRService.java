package app.domain.services;

import app.domain.model.User;
import java.util.ArrayList;
import java.util.List;

public class HRService {
    private final List<User> users = new ArrayList<>();

    // Crear usuario
    public void createUser(User user) {
        // Validar unicidad de cédula, correo y username
        for (User u : users) {
            if (u.getIdNumber().equals(user.getIdNumber())) {
                throw new IllegalArgumentException("El ID debe ser unico.");
            }
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                throw new IllegalArgumentException("El Email debe ser unico.");
            }
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                throw new IllegalArgumentException("El nombre de usuario debe ser unico.");
            }
        }
        users.add(user);
        System.out.println("Usuario creado satisfactoriamente: " + user.getFullName());
    }

    // Actualizar usuario
    public void updateUser(String idNumber, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            User existing = users.get(i);
            if (existing.getIdNumber().equals(idNumber)) {
                users.set(i, updatedUser);
                System.out.println("Usuario actualizado satisfactoriamente: " + updatedUser.getFullName());
                return;
            }
        }
        throw new IllegalArgumentException("El usuario con ID " + idNumber + " No se encuentra.");
    }

    // Eliminar usuario
    public void deleteUser(String idNumber) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getIdNumber().equals(idNumber)) {
                System.out.println("Usuario eliminado satisfactoriamente: " + users.get(i).getFullName());
                users.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Usuario con ID " + idNumber + " mo ha sido encontrado.");
    }

    // Buscar usuario por cédula
    public User getUserById(String idNumber) {
        for (User u : users) {
            if (u.getIdNumber().equals(idNumber)) {
                return u;
            }
        }
        throw new IllegalArgumentException("Usuario con ID " + idNumber + " no ha sido encontrado");
    }

    // Listar todos los usuarios
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
