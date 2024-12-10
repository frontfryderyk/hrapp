package projekty.hrapp.repository;

import org.springframework.data.repository.CrudRepository;
import projekty.hrapp.model.entity.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Integer> {
}
