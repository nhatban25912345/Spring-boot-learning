package org.example.springbootlearning.modal.mapper;

import org.example.springbootlearning.dto.ProjectDTO;
import org.example.springbootlearning.modal.entity.Project;

public class ProjectMapper {

    public static ProjectDTO maptoProjectDTO(Project project) {
        return ProjectDTO.builder()
                .id(project.getId())
                .projectName(project.getProjectName())
                .purpose(project.getPurpose())
                .amountPerson(project.getAmountPerson())
                .technology(project.getTechnology())
                .build();
    }

    public static Project maptoProject(ProjectDTO projectDTO) {
        return Project.builder()
                .id(projectDTO.getId())
                .projectName(projectDTO.getProjectName())
                .purpose(projectDTO.getPurpose())
                .amountPerson(projectDTO.getAmountPerson())
                .technology(projectDTO.getTechnology())
                .build();
    }

}
