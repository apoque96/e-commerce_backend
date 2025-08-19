package com.platoons.e_commerce.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdateCustomerRequestDto {
    @Size(min = 2, message = "Username must be at least 2 characters long")
    @Size(max = 32, message = "Username must be at most 32 characters long")
    @NotNull
    private String username;

    @NotNull(message = "Password is required")
    private String password;

    @Email
    @NotNull
    private String email;

    @Pattern(regexp = "^\\+([0-9]{1,4})[-\\s]?([0-9]{1,15})$", message = "Must be a valid phone number")
    private String phoneNumber;

    @NotNull(message = "First name is required")
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    @NotBlank(message = "Last name is required")
    private String lastName;
}
