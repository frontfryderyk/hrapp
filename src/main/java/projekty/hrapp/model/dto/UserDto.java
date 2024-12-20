package projekty.hrapp.model.dto;

public class UserDto {
    private Long id;
    private String username;
    private String eloRating;

    public UserDto(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.eloRating = "0"; //jaka wartosc?
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEloRating() {
        return eloRating;
    }

    public void setEloRating(String eloRating) {
        this.eloRating = eloRating;
    }
}
