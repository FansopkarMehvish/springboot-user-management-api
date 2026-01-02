package com.pow.user.management.api.dto;

import com.pow.user.management.api.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserReqDto {

    @NotBlank(message = "Name should not be blank")
    private String name;

    @Email
    @NotBlank(message = "Email should not be blank")
    private String email;

    @NotNull(message = "Role should not be null")
    private Role role;
}
