package projekty.hrapp.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import projekty.hrapp.model.enums.UserTypeEnum;

@Table(name = "user_type")
@Entity
public class UserType {
    @Id
    private Long id;
    private UserTypeEnum type;
    //private List<User> users=new ArrayList<>();

    public UserType(Long id, UserTypeEnum type) {
        this.id = id;
        this.type = type;
    }

    public UserType() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    //public List<User> getUsers(){
    // return users;
}




