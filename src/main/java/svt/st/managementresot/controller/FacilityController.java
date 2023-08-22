package svt.st.managementresot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import svt.st.managementresot.dto.service.FacilityDto;
import svt.st.managementresot.entity.service.Facility;
import svt.st.managementresot.entity.service.FacilityType;
import svt.st.managementresot.entity.service.RentType;
import svt.st.managementresot.mapper.FacilityMapper;
import svt.st.managementresot.service.FacilityService;
import svt.st.managementresot.service.FacilityTypeService;
import svt.st.managementresot.service.RentTypeService;


@Controller
public class FacilityController {

    @Autowired
    private FacilityTypeService facilityTypeService;
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("/creation_service")
    public String viewCreateServicePage(Model model){
        model.addAttribute("list_facility_type", facilityTypeService.getAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        return "CreationService";
    }

    @GetMapping("/services")
    public String viewServices(@RequestParam(defaultValue = "0") int page, Model model){
        int pageSize = 5;
        Page<Facility> facilityPages =  facilityService.findAll(page,pageSize);
        model.addAttribute("facilitys", facilityPages.getContent());
        model.addAttribute("page", facilityPages);
        return "service";
    }

    @ModelAttribute("facility")
    public FacilityDto facility( Model model){
        model.addAttribute("list_facility_type", facilityTypeService.getAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        return  new FacilityDto();
    }

    @PostMapping("/creation")
    public String creation(@ModelAttribute FacilityDto facilityDto){
        facilityService.save(facilityDto);
        return "redirect:/services";
    }

    @GetMapping  ("/services/edit/{id}")
    public String editFacility(@PathVariable Long id,  Model model){
        FacilityDto facilityDto1 = facilityService.finFacilityById(id);
        facilityDto1.setId(id);
        model.addAttribute("facilityUpdate", facilityDto1);
        return "EditFacility";
    }

    @PostMapping("services/{id}")
    public String updateFacility(@PathVariable("id") Long id, @ModelAttribute("facilityUpdate ") FacilityDto facilityDto, Model model){
        FacilityDto facilityDto1 = facilityService.finFacilityById(id);

        facilityDto1.setId(facilityDto.getId());
        facilityDto1.setName(facilityDto.getName());
        facilityDto1.setArea(facilityDto.getArea());
        facilityDto1.setCost(facilityDto.getCost());
        facilityDto1.setMax_people(facilityDto.getMax_people());
        facilityDto1.setStandardRoom(facilityDto.getStandardRoom());
        facilityDto1.setDescription_other_convenience(facilityDto.getDescription_other_convenience());
        facilityDto1.setPool_area(facilityDto.getPool_area());
        facilityDto1.setNumber_of_floors(facilityDto.getNumber_of_floors());

        facilityDto1.setId_facilityType(facilityDto.getId_facilityType());
        facilityDto1.setId_rentType(facilityDto.getId_rentType());

        Facility facility=  FacilityMapper.toEntity(facilityDto1);
        facilityService.update(facility);
        return "redirect:/services";
    }


    @GetMapping ("services/delete/{id}")
    public String deleteFacility(@PathVariable("id") Long id){
        facilityService.deleteById(id);
        return "redirect:/services";
    }





}












