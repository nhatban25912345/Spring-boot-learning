package org.example.springbootlearning.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private long id;
    private String projectName;
    private String purpose;
    private int amountPerson;
    private String technology;
}
