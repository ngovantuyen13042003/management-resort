package svt.st.managementresot.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name should not be empty!")
    private String name;
    @NotNull(message = "Date of birth should not be empty!")
//    @DateTimeFormat (pattern = "mm/dd/yyyy")
    private Date dateOfBirth;
    @NotEmpty(message = "Identity card should not be empty!")
    private String idCard;
    @NotEmpty(message = "Phone number should not be empty!")
    private String phoneNumber;
    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email address invalid!")
    private String email;
    @NotEmpty(message = "Address should not be empty!")
    private String address;
//    @NotNull(message = "Position should not be empty!")
    private Long position_id;
//    @NotNull(message = "Division should not be empty!")
    private Long division_id;
//    @NotNull(message = "Education degree should not be empty!")
    private  Long education_degree_id;
//    @NotNull(message = "User should not be empty!")
    private  String  id_user;



}
