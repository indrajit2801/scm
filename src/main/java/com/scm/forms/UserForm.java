package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserForm {

    @NotBlank(message = "Username is required")
    @Size(min=3, message = "Min 3 character is required")
    private String name;

    @Email(message = "Invalid Email Address")
    private String email;
    private String password;

    @NotBlank(message = "About is Required")
    private String about;

    @Size(min=8,max=12, message = "Invalid Phone Number")
    private String phoneNumber;

   
}
