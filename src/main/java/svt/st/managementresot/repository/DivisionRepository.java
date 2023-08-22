package svt.st.managementresot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import svt.st.managementresot.entity.employee.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long> {
}
