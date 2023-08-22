package svt.st.managementresot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import svt.st.managementresot.dto.employee.EmployeeDTO;
import svt.st.managementresot.entity.employee.Employee;
import svt.st.managementresot.mapper.EmployeeMapper;
import svt.st.managementresot.service.*;

@Controller
public class EmployeeController {

    @Autowired
    private DivisionService divisionService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
//    private EmployeeMapper employeeMapper;


    @GetMapping("/add-info-employee")
    public  String viewEmployee(Model model){
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("users", userService.findAll());

        EmployeeDTO employeeDTO = new EmployeeDTO();
        model.addAttribute("employee",employeeDTO);
        return "AddInfoEmployee";
    }

    @PostMapping("/add-info-employee/save")
    public String additionInfoEmployee(@Valid @ModelAttribute("employee") EmployeeDTO employeeDTO, BindingResult result, Model model){

        Employee emailExist = employeeService.findByEmail(employeeDTO.getEmail());
        Employee phoneNumberExist =  employeeService.findByPhoneNumber(employeeDTO.getPhoneNumber());
        Employee idCardExist = employeeService.findByIdCard(employeeDTO.getIdCard());

        if(emailExist != null) {
            System.out.println("failed email");
            result.rejectValue("email", null, "There is already an employee use the same email!");
        }

        if(phoneNumberExist != null) {
            System.out.println("failed phone number");
            result.rejectValue("phoneNumber", null, "There is already an employee use the same phone number!");
        }

        if(idCardExist != null) {
            System.out.println("failed card ");
            result.rejectValue("idCard", null, "There is already an employee use the same identity card number!");
        }

        if (result.hasErrors()){
            model.addAttribute("employee", employeeDTO);
            model.addAttribute("divisions", divisionService.findAll());
            model.addAttribute("positions", positionService.findAll());
            model.addAttribute("educationDegrees", educationDegreeService.findAll());
            model.addAttribute("users", userService.findAll());
            System.out.println("failed");
            return "AddInfoEmployee";
        }

        System.out.println("success");
        employeeService.save(EmployeeMapper.employeeDTOToEmployee(employeeDTO));

        return "redirect:/account";
    }






}
