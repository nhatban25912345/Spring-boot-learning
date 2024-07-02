package org.example.springbootlearning.service;

import org.example.springbootlearning.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO createProject(ProjectDTO projectDTO);
    ProjectDTO updateProject(Long id,ProjectDTO projectDTO);
    List<ProjectDTO> getAllProjects();
    ProjectDTO getProjectById(Long id);
    void deleteProjectById(Long id);
}
