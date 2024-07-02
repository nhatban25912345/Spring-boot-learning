package org.example.springbootlearning.controller;

import lombok.AllArgsConstructor;
import org.example.springbootlearning.dto.ProjectDTO;
import org.example.springbootlearning.factory.response.GeneralResponse;
import org.example.springbootlearning.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @RequestMapping(path = "api/project/create-project")
    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO){
        ProjectDTO saveProject = projectService.createProject(projectDTO);
        return new ResponseEntity<>(saveProject, HttpStatus.CREATED);
    }

    @RequestMapping(path = "api/project/list-project")
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProject(){
        List<ProjectDTO> projectList = projectService.getAllProjects();
        return ResponseEntity.ok(projectList);
    }

    @RequestMapping(path = "api/project/{id}")
    @GetMapping
    public ResponseEntity<GeneralResponse> getProjectById(@PathVariable Long id){
        ProjectDTO project = projectService.getProjectById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new GeneralResponse(HttpStatus.OK, "Get data successfully", project)
        );
    }

    @RequestMapping(path = "api/project/update-project/{id}")
    @PutMapping
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectUpdate){
        ProjectDTO projectDto = projectService.updateProject(id, projectUpdate);
        return ResponseEntity.ok(projectDto);
    }

    @RequestMapping(path = "api/project/delete-project/{id}")
    @DeleteMapping
    public String deleteProject(@PathVariable Long id){
        projectService.deleteProjectById(id);
        return "Project deleted";
    }
}
