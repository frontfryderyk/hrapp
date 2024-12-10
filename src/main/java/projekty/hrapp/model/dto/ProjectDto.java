package projekty.hrapp.model.dto;

public class ProjectDto {
    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectDto(String description, String name, int id) {
        this.description = description;
        this.name = name;
        this.id = id;


    }
}
