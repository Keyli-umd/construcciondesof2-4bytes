package app.application.usecases;

import app.domain.services.HRService;
import app.domain.model.enums.Role;

public class ManageUserAccessUseCase {
    private final HRService hrService;

    public ManageUserAccessUseCase(HRService hrService) {
        this.hrService = hrService;
    }

    public void execute(String idCard, Role newRole) {
        hrService.updateRole(idCard, newRole);
    }
}
