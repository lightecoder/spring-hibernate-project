package demo.controller;

import demo.entity.Activity;
import demo.entity.Tracking;
import demo.entity.User;
import demo.services.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Slf4j
@Controller
@SessionAttributes(names = {"user", "trackingList", "userList", "activity", "activityList", "errorMessage"})
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute(name = "userList")
    public List<User> userList() {
        return new ArrayList<>();
    }
    @ModelAttribute(name = "activity")
    public Activity activity() {
        return new Activity();
    }
    @ModelAttribute(name = "activityList")
    public List<Activity> activityList() {
        return new ArrayList<>();
    }
    @ModelAttribute(name = "errorMessage")
    public String errorMessage() {
        return new String();
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @ModelAttribute(name = "trackingList")
    public List<Tracking> trackingList() {
        return new ArrayList<>();
    }

    @PostMapping("/user")
    public String login(User user, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            return "login";
//        }
        return userService.checkClientOrAdmin(user, model);
    }

    @GetMapping("/internationalUser")
    public String international() {
        return "user";
    }

}
