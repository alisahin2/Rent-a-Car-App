package sample.rentacar.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "car_type")
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name= "type")
    private String type;

    @OneToMany(mappedBy = "carType" , cascade = CascadeType.ALL)
    private Set<Car> cars;
}
