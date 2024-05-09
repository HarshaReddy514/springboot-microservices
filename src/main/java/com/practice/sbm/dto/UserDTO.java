package com.practice.sbm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotEmpty(message = "User First Name  should not be null or empty")
    private String first_name;

    @NotEmpty(message = "User Last Name  should not be null or empty")
    private String last_name;

    @NotEmpty(message = "User Email  should not be null or empty")
    @Email(message = "Email should be a valid one")
    private String email;
}
