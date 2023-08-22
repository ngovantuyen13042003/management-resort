package svt.st.managementresot.mapper;

import svt.st.managementresot.dto.employee.UserDTO;
import svt.st.managementresot.entity.employee.User;
import svt.st.managementresot.utils.EncodePassword;

public class UserMapper {

    public static User toUserEntity(UserDTO userDTO){
        User user = new User();

        user.setUserName(userDTO.getUserName());
        user.setPassword(EncodePassword.passwordEncoder().encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());

        return user;
    }

    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }


}
