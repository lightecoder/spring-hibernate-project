package demo.dao;

import demo.entity.User;
import demo.entity.UserType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLoginAndPassword(String login, String password);
    List<User> findAllByUserType(UserType userType);
}
