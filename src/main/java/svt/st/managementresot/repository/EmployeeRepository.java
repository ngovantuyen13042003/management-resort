package svt.st.managementresot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import svt.st.managementresot.entity.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);

    Employee findByIdCard(String idCard);

    Employee findByPhoneNumber(String phoneNumber);

    @Query("SELECT e FROM Employee e WHERE e.user.userName = ?1")
    Employee findByUser_UserName(String username);

}
