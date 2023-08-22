package svt.st.managementresot.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    private String userName;
    private String password;
    private String email;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns =  @JoinColumn(name="username",referencedColumnName = "userName"),
            inverseJoinColumns = @JoinColumn(name="role_id)",referencedColumnName = "id")
    )
    private List<Role> role;

    public User(String userName) {
        this.userName = userName;
    }
}
