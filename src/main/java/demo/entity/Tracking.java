package demo.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tracking")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "user_request_id")
    private UserRequest userRequest;
    @Column(name = "time")
    private String time;
    @Column(name = "time_start")
    private Long timeStart;
    @Column(name = "time_stop")
    private Long timeStop;
    @Column(name = "difference_time")
    private Long differenceTime;
    @Column(name = "time_switch")
    private Boolean timeSwitch;
}
