package demo.services;

import demo.dao.ActivityRepository;
import demo.dao.TrackingRepository;
import demo.dao.UserRepository;
import demo.entity.Activity;
import demo.entity.Tracking;
import demo.entity.User;
import demo.entity.UserType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserServiceImpl implements UserService {

    private static final String ADMIN = "admin";
    private final UserRepository userRepository;
    private final TrackingRepository trackingRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TrackingRepository trackingRepository, ActivityRepository activityRepository) {
        this.userRepository = userRepository;
        this.trackingRepository = trackingRepository;
        this.activityRepository=activityRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> chekIfUserPresentInDb(User user) {
        Optional<User> result = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        return result;
    }

    @Override
    public List<Tracking> findAllTrackingActivityByUserId(User user) {
        return trackingRepository.findAllByUserId(user.getId());
    }

    @Override
    public String checkClientOrAdmin(User user, Model model) {
        Optional<User> currentUser = chekIfUserPresentInDb(user);
        if (currentUser.isPresent()) {
            List<User> userList = userRepository.findAllByUserType(new UserType(2L, "client"));
            List<Tracking> trackingList = findAllTrackingActivityByUserId(currentUser.get());
            List<Activity>activityList= (List<Activity>) activityRepository.findAll();
            model.addAttribute("trackingList", trackingList);
            model.addAttribute("user", currentUser.get());
            model.addAttribute("userList", userList);
            model.addAttribute("activityList", activityList);

            if (currentUser.get().getUserType().getType().equals(ADMIN)) {
                return "admin";
            }
            return "user";
        }
        model.addAttribute("errorMessage", "Incorrect login or password");
        return "login";
    }
}
