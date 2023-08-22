package svt.st.managementresot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import svt.st.managementresot.dto.service.FacilityDto;
import svt.st.managementresot.entity.service.Facility;
import svt.st.managementresot.mapper.FacilityMapper;
import svt.st.managementresot.repository.FacilityRepository;
import svt.st.managementresot.service.FacilityService;

import java.util.List;


@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;
    @Override
    public Page<Facility> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return facilityRepository.findAll(pageable);
    }

    @Override
    public Facility save(FacilityDto facilityDto) {
        Facility facility = FacilityMapper.toEntity(facilityDto);
        return facilityRepository.save(facility);
    }

    @Override
    public Facility update(Facility facility) {
        return  facilityRepository.save(facility);
    }

    @Override
    public FacilityDto finFacilityById(Long id) {
        Facility facility = facilityRepository.findById(id).get();
        FacilityDto facilityDto =  FacilityMapper.toEntityDTO(facility);
        return facilityDto;
    }

    @Override
    public void deleteById(Long id) {
         facilityRepository.deleteById(id);
    }

//    @Override
//    public List<Facility> searchServices(String query) {
//        return facilityRepository.searchServices(query);
//    }
}
