package svt.st.managementresot.dto.service;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FacilityDto {
    private Long id;
    private String name;
    private int area;
    private Double cost;
    private int max_people;
    private String standardRoom;
    private String description_other_convenience;
    private Double pool_area;
    private int number_of_floors;
    private Long id_facilityType;
    private Long id_rentType;
}
