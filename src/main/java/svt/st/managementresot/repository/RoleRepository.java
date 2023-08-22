package svt.st.managementresot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import svt.st.managementresot.entity.employee.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   Role findByName(String name);
}
