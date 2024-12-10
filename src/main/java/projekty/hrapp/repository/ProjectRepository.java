package projekty.hrapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projekty.hrapp.model.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
