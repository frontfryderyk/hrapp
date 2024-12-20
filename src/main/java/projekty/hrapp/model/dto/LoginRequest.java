package projekty.hrapp.model.dto;

public class LoginRequest {
    private String name;
    private String email;
    private String password;

    public LoginRequest() {
    }

    ;

    public LoginRequest(String login, String haslo) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
