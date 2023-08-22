package svt.st.managementresot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import svt.st.managementresot.entity.service.FacilityType;
import svt.st.managementresot.repository.FacilityTypeRepository;
import svt.st.managementresot.service.FacilityTypeService;

import java.util.List;

@Service
public class FacilityTypeServiceImpl implements FacilityTypeService {

    @Autowired
    private FacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> getAll() {
        return facilityTypeRepository.findAll();
    }
}
