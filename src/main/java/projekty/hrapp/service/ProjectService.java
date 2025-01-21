package projekty.hrapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekty.hrapp.model.dto.ProjectDto;
import projekty.hrapp.model.entity.Project;
import projekty.hrapp.repository.ProjectRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectDto> getAllProjects(){
        return projectRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ProjectDto getProjectById(Long id){
        return projectRepository.findById(Math.toIntExact(id))
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }


    private ProjectDto convertToDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .build();
    }


}
