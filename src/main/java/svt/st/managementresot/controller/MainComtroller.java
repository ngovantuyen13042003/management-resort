package svt.st.managementresot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import svt.st.managementresot.service.FacilityTypeService;

@Controller
public class MainComtroller {
    @Autowired
    private FacilityTypeService facilityTypeService;


    @GetMapping
    public String viewHomepage(){
        return "Home";
    }






}
