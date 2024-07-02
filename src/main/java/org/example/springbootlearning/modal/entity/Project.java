package org.example.springbootlearning.modal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "amount")
    private int amountPerson = 0;

    @Column(name = "technology")
    private String technology;
}
