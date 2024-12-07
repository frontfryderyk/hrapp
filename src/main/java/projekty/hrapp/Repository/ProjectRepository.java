package projekty.hrapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projekty.hrapp.Model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
