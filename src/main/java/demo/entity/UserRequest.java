package demo.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_request")
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_request_name", length = 20)
    private String name;
}
