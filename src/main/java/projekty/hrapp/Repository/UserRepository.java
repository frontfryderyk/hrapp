package projekty.hrapp.Repository;

import org.springframework.data.repository.CrudRepository;
import projekty.hrapp.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
