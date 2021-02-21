package demo.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "status_name", length = 20)
    private String name;
}
