package com.kiguel.dto;

import com.kiguel.utils.permission_roles.ConstructorRolePermission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDTO {

    public JwtResponseDTO(String accessToken, ConstructorRolePermission constructorRolePermission) {
    }
    private String token;
    private RoleDTO role;
}