package svt.st.managementresot.service;

import svt.st.managementresot.dto.employee.UserDTO;
import svt.st.managementresot.entity.employee.User;

import java.util.List;

public interface UserService {
    User save(UserDTO userDTO);

    User findUserByEmail(String email);


    List<UserDTO> findAll();

}
