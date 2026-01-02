package com.pow.user.management.api.dto;

import com.pow.user.management.api.enums.Role;
import lombok.Data;

@Data
public class UserResDto {
    private Integer id;
    private String name;
    private String email;
    private Role role;
}
