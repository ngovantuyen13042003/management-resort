package svt.st.managementresot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import svt.st.managementresot.entity.service.Facility;

import java.util.List;


@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    Page<Facility> findAll(Pageable pageable);
//
//    @Query("SELECT s FROM Facility s WHERE s.name LIKE % :query % or s.standardRoom LIKE % :query %")
//    List<Facility>  searchServices(String query);
}
