package com.megadiiiii.web.services;

import com.megadiiiii.web.dto.RegistrationDto;
import com.megadiiiii.web.models.UserEntity;
import jakarta.validation.constraints.NotEmpty;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(@NotEmpty String email);

    UserEntity findByUsername(@NotEmpty String username);
}
