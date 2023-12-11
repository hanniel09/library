package com.hanniel.library.dtos;

import com.hanniel.library.models.RoleModel;

import java.util.List;

public record UserDTO(String username, String password, List<RoleModel> roles) {
}
