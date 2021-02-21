package demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "user")
public class User implements Cloneable, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Required not blank field.")
    @Column(name = "first_name", length = 20)
    private String firstName;
    @NotBlank(message = "Required not blank field.")
    @Column(name = "sur_name", length = 20)
    private String surName;
    @NotBlank(message = "Required not blank field.")
    @Length(min = 3, message = "Required min 3 symbols!")
    @Column(name = "login", length = 20)
    private String login;
    @NotBlank(message = "Required not blank field.")
    @Column(name = "password", length = 20)
    private String password;
    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;
    @Column(name = "request_add", length = 20)
    private Boolean requestAdd;

    public static User clone(User user) throws CloneNotSupportedException {
        User clone = (User) user.clone();
        user.setUserType(user.getUserType().clone());
        return clone;
    }
}
