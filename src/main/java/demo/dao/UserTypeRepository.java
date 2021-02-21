package demo.dao;

import demo.entity.UserType;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeRepository extends CrudRepository<UserType, Long> {
}
