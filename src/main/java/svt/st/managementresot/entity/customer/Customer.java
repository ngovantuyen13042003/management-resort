package svt.st.managementresot.entity.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dateOfBirth;
    private String gender;
    private String id_card;
    private String phoneNumber;
    @Email(message = "Email address invalid!")
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_customerType")
    private CustomerType customerType;
}
