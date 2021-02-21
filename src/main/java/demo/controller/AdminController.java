package demo.controller;

import demo.entity.Activity;
import demo.entity.Tracking;
import demo.entity.User;
import demo.services.AdminService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(
        names = {"userList", "activity", "trackingList", "activityList"}
)
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute(name = "userList")
    public List<User> user() {
        return new ArrayList<>();
    }

    @ModelAttribute(name = "trackingList")
    public List<Tracking> trackingList() {
        return new ArrayList<>();
    }

    @ModelAttribute(name = "activity")
    public Activity activity() {
        return new Activity();
    }

    @ModelAttribute(name = "activityList")
    public List<Activity> activityAdminList() {
        return new ArrayList<>();
    }

    @PostMapping("/admin")
    public String userPage() {
        return "admin";
    }

    @GetMapping("/internationalAdmin")
    public String international() {
        return "admin";
    }

    @PostMapping("/createActivity")
    public String addActivity(Activity activity, Model model) throws CloneNotSupportedException {
        adminService.saveActivity(activity.clone());
        List<Activity> activityList=adminService.findAllActivities();
        model.addAttribute("activityList", activityList);
        return "admin";
    }

    @PostMapping("/overviewClient")
    public String overviewClient(Activity activity) {
        return "overviewClient";
    }

    @GetMapping("/overviewClient")
    public String internationalOverview() {
        return "overviewClient";
    }
}
