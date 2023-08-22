package svt.st.managementresot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import svt.st.managementresot.entity.service.RentType;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Long> {
}
