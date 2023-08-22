package svt.st.managementresot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import svt.st.managementresot.entity.employee.EducationDegree;
@Repository
public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Long> {
}
