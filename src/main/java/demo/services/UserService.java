package demo.services;

import demo.entity.Tracking;
import demo.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;
public interface UserService {

    void save(User user);

    Optional<User> chekIfUserPresentInDb(User user);

    List<Tracking> findAllTrackingActivityByUserId(User user);

    String checkClientOrAdmin(User user, Model model);

}
