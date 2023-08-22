package svt.st.managementresot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import svt.st.managementresot.entity.employee.Division;
import svt.st.managementresot.repository.DivisionRepository;
import svt.st.managementresot.service.DivisionService;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
