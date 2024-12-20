package projekty.hrapp.model.dto;

public class UserResponse {
    private Integer id;
    private String name;
    private String email;

    public UserResponse(Integer ID, String imie, String nazwisko, String dataurodzenia) {
        this.id = id;
        this.name = name;
        this.email = email;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
