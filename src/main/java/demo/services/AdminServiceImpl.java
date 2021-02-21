package demo.services;

import demo.dao.ActivityRepository;
import demo.entity.Activity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AdminServiceImpl implements AdminService {
    private final ActivityRepository activityRepository;

    @Autowired
    public AdminServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void saveActivity(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public List<Activity> findAllActivities() {
        return (List<Activity>) activityRepository.findAll();
    }
}
