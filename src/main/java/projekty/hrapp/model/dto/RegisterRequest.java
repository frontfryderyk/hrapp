package projekty.hrapp.model.dto;

public class RegisterRequest {
    private String login;
    private String password;
    private Long userType;

    public Long getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

}
