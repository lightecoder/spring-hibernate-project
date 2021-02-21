package demo.services;

import demo.entity.Activity;
import java.util.List;

public interface AdminService {

    void saveActivity(Activity activity);

    List<Activity> findAllActivities();
}
