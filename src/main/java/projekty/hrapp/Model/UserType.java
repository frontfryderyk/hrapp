package projekty.hrapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="user_type")
@Entity
public class UserType {
    @Id
    private Long id;
    private String type;

    public UserType(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public UserType() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }
}
