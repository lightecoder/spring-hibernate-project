package demo.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "activity")
public class Activity implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "activity_name", length = 20)
    private String activityName;

    public Activity() {
    }

    public Activity(String activityName) {
        this.activityName = activityName;
    }
    @Override
    public Activity clone() throws CloneNotSupportedException{
        return (Activity)super.clone();
    }

}
