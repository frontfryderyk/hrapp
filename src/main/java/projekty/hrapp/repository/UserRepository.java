package projekty.hrapp.repository;

import org.springframework.data.repository.CrudRepository;
import projekty.hrapp.model.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
