package svt.st.managementresot.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import svt.st.managementresot.dto.employee.EmployeeDTO;
import svt.st.managementresot.entity.employee.*;


//@Component

public class EmployeeMapper {



    public static EmployeeDTO employeeToEmployeeDTO(Employee employee){
        EmployeeDTO employeeDto = new EmployeeDTO();
        employeeDto.setName(employee.getName());
        employeeDto.setDateOfBirth(employee.getDateOfBirth());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setIdCard(employee.getIdCard());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setDivision_id(employee.getDivision().getId());
        employeeDto.setId_user(employee.getUser().getUserName());
        employeeDto.setPosition_id(employee.getPosition().getId());
        employeeDto.setEducation_degree_id(employee.getEducationDegree().getId());
        return employeeDto;
    }

    public static Employee employeeDTOToEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setEmail(employeeDTO.getEmail());
        employee.setAddress(employeeDTO.getAddress());
        employee.setIdCard(employeeDTO.getIdCard());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setDivision(new Division(employeeDTO.getDivision_id()));
        employee.setUser(new User(employeeDTO.getId_user()));
        employee.setPosition(new Position(employeeDTO.getPosition_id()));
        employee.setEducationDegree(new EducationDegree(employeeDTO.getEducation_degree_id()));
        return employee;
    }

}
