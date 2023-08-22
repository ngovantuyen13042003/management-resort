package svt.st.managementresot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import svt.st.managementresot.dto.service.FacilityDto;
import svt.st.managementresot.entity.service.Facility;

import java.util.List;

@Service
public interface FacilityService {
    Page<Facility> findAll(int page, int size);

    Facility save(FacilityDto facilityDto);

    Facility update(Facility facility);

    FacilityDto finFacilityById(Long id);

    void deleteById(Long id);

//    List<Facility> searchServices(String query);

}
