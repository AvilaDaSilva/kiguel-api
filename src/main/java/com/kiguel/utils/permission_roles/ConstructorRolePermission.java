package com.kiguel.utils.permission_roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kiguel.dto.RoleDTO;
import com.kiguel.entities.UserEntity;

public class ConstructorRolePermission {
    
    public RoleDTO getRightRole(UserEntity userEntity) {
        switch (userEntity.getRole().name()) {
            case "Admin":
                return new RoleDTO(userEntity.getRole().name(), this.getAdminPermission());
            case "Staff":
                return new RoleDTO(userEntity.getRole().name(), this.getStaffPermission());
            case "CupStaff":
                return new RoleDTO(userEntity.getRole().name(), this.getCupStaffPermission());
            case "Player":
                return new RoleDTO(userEntity.getRole().name(), this.getPlayerPermission());
        }

        return null;
    }

    private List<String> getAdminPermission() {
        return new ArrayList<String>(Arrays.asList("teams", "players", "championship"));
    }

    private List<String> getStaffPermission() {
        return new ArrayList<String>(Arrays.asList("teams", "players", "championship"));
    }

    private List<String> getCupStaffPermission() {
        return new ArrayList<String>(Arrays.asList("teams", "players", "championship"));
    }

    private List<String> getPlayerPermission() {
        return new ArrayList<String>(Arrays.asList("teams", "players", "championship"));
    }
}
