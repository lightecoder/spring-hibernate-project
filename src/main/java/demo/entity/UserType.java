package demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.sql.rowset.serial.SerialArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_type")
public class UserType implements Cloneable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "user_type_name", length = 20)
    private String type;

    @Override
    protected UserType clone() throws CloneNotSupportedException {
        return (UserType) super.clone();
    }
}
