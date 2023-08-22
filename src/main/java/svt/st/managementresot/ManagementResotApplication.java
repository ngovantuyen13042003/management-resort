package svt.st.managementresot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import svt.st.managementresot.entity.service.Facility;
import svt.st.managementresot.entity.service.FacilityType;
import svt.st.managementresot.service.FacilityTypeService;

@SpringBootApplication
public class ManagementResotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementResotApplication.class, args);
    }




}
