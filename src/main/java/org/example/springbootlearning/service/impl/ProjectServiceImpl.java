package org.example.springbootlearning.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.springbootlearning.dto.ProjectDTO;
import org.example.springbootlearning.exception.ResourceNotFoundException;
import org.example.springbootlearning.modal.entity.Project;
import org.example.springbootlearning.modal.mapper.ProjectMapper;
import org.example.springbootlearning.repository.ProjectRepository;
import org.example.springbootlearning.service.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Override
    @Transactional
    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project newProject = ProjectMapper.maptoProject(projectDTO);
        projectRepository.save(newProject);
        return projectDTO;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        return projectList.stream().map(ProjectMapper::maptoProjectDTO).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
        return ProjectMapper.maptoProjectDTO(project);
    }

    @Override
    @Transactional
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        projectDTO.setId(id);
        BeanUtils.copyProperties(projectDTO, project);
        Project updateProjectObj = projectRepository.save(project);
        return ProjectMapper.maptoProjectDTO(updateProjectObj);
    }

    @Override
    @Transactional
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

}
