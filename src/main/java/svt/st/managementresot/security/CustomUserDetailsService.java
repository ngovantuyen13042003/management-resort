package svt.st.managementresot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import svt.st.managementresot.entity.employee.User;
import svt.st.managementresot.repository.UserRepository;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(usernameOrEmail);

        if (user != null){
            return new org.springframework.security.core.userdetails.User(user.getUserName(),
                                                                        user.getPassword(),
                                                                        user.getRole().stream()
                                                                                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                                                                                .collect(Collectors.toList()));
        }else {
            throw new UsernameNotFoundException("Invalid username or password!");
        }

    }
}
