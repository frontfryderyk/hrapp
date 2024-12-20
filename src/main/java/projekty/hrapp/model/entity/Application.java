package projekty.hrapp.model.entity;

import jakarta.persistence.*;
import projekty.hrapp.model.enums.ApplicationStatus;

@Table(name = "applications")
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(nullable = false)
    private ApplicationStatus applicationStatus = ApplicationStatus.PENDING;

    public Application() {
    }

    ;

    public Application(User user, Project project) {
        this.user = user;
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }


}
