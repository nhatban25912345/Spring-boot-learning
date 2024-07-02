package org.example.springbootlearning.dto;

import javax.validation.constraints.*;

import lombok.*;
import org.example.springbootlearning.Validator.ValidateConstant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private long id;

    @Size(max = 5, message = "loi nhap du lieu")
    private String firstName;

    private String lastName;

    @Email(message = ValidateConstant.NOT_EMAIL)
    private String email;
}
