package svt.st.managementresot.mapper;

import svt.st.managementresot.dto.service.FacilityDto;
import svt.st.managementresot.entity.service.Facility;
import svt.st.managementresot.entity.service.FacilityType;
import svt.st.managementresot.entity.service.RentType;

public class FacilityMapper {

    public static FacilityDto toEntityDTO(Facility facility){
        FacilityDto facilityDto = new FacilityDto();

        facilityDto.setName(facility.getName());
        facilityDto.setArea(facility.getArea());
        facilityDto.setCost(facility.getCost());
        facilityDto.setMax_people(facility.getMax_people());
        facilityDto.setStandardRoom(facility.getStandardRoom());
        facilityDto.setDescription_other_convenience(facility.getDescription_other_convenience());
        facilityDto.setPool_area(facility.getPool_area());
        facilityDto.setNumber_of_floors(facility.getNumber_of_floors());

        facilityDto.setId_facilityType(facility.getFacilityType().getId());
        facilityDto.setId_rentType(facility.getRentType().getId());

        return  facilityDto;
    }

    public static Facility toEntity(FacilityDto facilityDto){
        Facility facility = new Facility();

        facility.setId(facilityDto.getId());
        facility.setName(facilityDto.getName());
        facility.setArea(facilityDto.getArea());
        facility.setCost(facilityDto.getCost());
        facility.setMax_people(facilityDto.getMax_people());
        facility.setStandardRoom(facilityDto.getStandardRoom());
        facility.setDescription_other_convenience(facilityDto.getDescription_other_convenience());
        facility.setPool_area(facilityDto.getPool_area());
        facility.setNumber_of_floors(facilityDto.getNumber_of_floors());

        FacilityType facilityType = new FacilityType();
        facilityType.setId(facilityDto.getId_facilityType());

        RentType rentType = new RentType();
        rentType.setId(facilityDto.getId_rentType());

        facility.setFacilityType(facilityType);
        facility.setRentType(rentType);

        return facility;
    }

}
