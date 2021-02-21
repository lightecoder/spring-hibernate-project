package demo.dao;

import demo.entity.Tracking;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TrackingRepository extends CrudRepository<Tracking, Long> {

    List<Tracking> findAllByUserId(Long id);
}
