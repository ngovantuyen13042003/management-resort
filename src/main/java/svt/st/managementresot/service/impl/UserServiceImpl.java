package svt.st.managementresot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import svt.st.managementresot.dto.employee.UserDTO;
import svt.st.managementresot.entity.employee.Role;
import svt.st.managementresot.entity.employee.User;
import svt.st.managementresot.mapper.UserMapper;
import svt.st.managementresot.repository.RoleRepository;
import svt.st.managementresot.repository.UserRepository;
import svt.st.managementresot.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User save(UserDTO userDTO) {
        User user = UserMapper.toUserEntity(userDTO);

        Role role = roleRepository.findByName("USER");
        if(role == null){
            role = checkRoleExists();
        }
        user.setRole(Arrays.asList(role));

        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS= new ArrayList<>();
        for (User user : users) {
            userDTOS.add(UserMapper.toUserDTO(user));
        }
        return userDTOS;
    }

    private Role checkRoleExists(){
        Role role = new Role();
        role.setName("USER");
        return  roleRepository.save(role);
    }

}
