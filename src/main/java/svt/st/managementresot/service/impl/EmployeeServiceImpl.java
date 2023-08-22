package svt.st.managementresot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import svt.st.managementresot.entity.employee.Employee;
import svt.st.managementresot.repository.EmployeeRepository;
import svt.st.managementresot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByIdCard(String idCard) {
        return employeeRepository.findByIdCard(idCard);
    }

    @Override
    public Employee findByPhoneNumber(String phoneNumber) {
        return employeeRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Employee findByUserName(String username) {
        return employeeRepository.findByUser_UserName(username);
    }
}
