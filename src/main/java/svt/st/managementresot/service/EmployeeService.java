package svt.st.managementresot.service;

import svt.st.managementresot.entity.employee.Employee;

public interface EmployeeService {
    Employee save(Employee employee);

    Employee findByIdCard(String idCard);
    Employee findByPhoneNumber(String phoneNumber);
    Employee findByEmail(String email);

    Employee findByUserName(String username);

}
