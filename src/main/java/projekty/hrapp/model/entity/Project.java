package projekty.hrapp.model.entity;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;



@Entity
@Builder
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    public Project(String description, String name, Long id) {
        this.description = description;
        this.name = name;
        this.id = (long) id;
    }

    public Project() {

    }

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


}
