package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(message = "minimum 3 characters required")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "invalid email address")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @Size(min = 8, max = 12,message = "invalid phone number")
    private String phoneNumber;
    @Size(min = 3)
    @NotBlank
    private String about;
}
