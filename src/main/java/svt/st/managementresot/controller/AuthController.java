package svt.st.managementresot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import svt.st.managementresot.dto.employee.UserDTO;
import svt.st.managementresot.entity.employee.User;
import svt.st.managementresot.service.EmployeeService;
import svt.st.managementresot.service.UserService;

import java.util.List;


@Controller
//@SessionAttributes("user")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    // Handler method to handle login request
    @GetMapping("/login")
    public String viewLogin(){
         return "Login";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String viewRegister(Model model){
        // create model object to store form data
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "Register";
    }

    // handler method to handle user registration submit form request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model){

        User existingUser = userService.findUserByEmail(userDTO.getEmail());
        if(existingUser !=null ){
            result.rejectValue("email",null ,
                    "There is a already an account registered with the same email!");
        }

        if(result.hasErrors()){
            model.addAttribute("user",userDTO);
            return "Register";
        }

        User user = userService.save(userDTO);
//        return "redirect:/register?success";
        return "redirect:/";
    }

    // handler method to handle display list of registered users
    @GetMapping("/users")
    public String users(Model model){
        List<UserDTO> users  = userService.findAll();
        model.addAttribute("users",users);
        return "Users";
    }


    @GetMapping("/account")
    public  String viewAccountPage(Model model){
        return "Account";
    }




}





