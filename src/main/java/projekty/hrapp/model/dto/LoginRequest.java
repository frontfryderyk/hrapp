package projekty.hrapp.model.dto;

public class LoginRequest {
    private String login;
    private String password;

    public LoginRequest() {
    }

    ;

    public LoginRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
