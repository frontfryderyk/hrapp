package projekty.hrapp.model.dto;
import lombok.Builder;



@Builder
public class ProjectDto {
    private Long id;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectDto(String description, String name, Long id) {
        this.description = description;
        this.name = name;
        this.id = id;


    }
}
