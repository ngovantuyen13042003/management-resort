package svt.st.managementresot.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "cart")
public class CartItem {
    @Id

    private Long productId;
    private String name;
    private Double price;
    private int qty = 1;


}