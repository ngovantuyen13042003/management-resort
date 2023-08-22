package svt.st.managementresot.entity.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int area;
    private Double cost;
    private int max_people;
    private String standardRoom;
    private String description_other_convenience;
    private Double pool_area;
    private int number_of_floors;

    @ManyToOne
    @JoinColumn(name = "id_facilityType")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "id_rentType")
    private RentType rentType;

}
