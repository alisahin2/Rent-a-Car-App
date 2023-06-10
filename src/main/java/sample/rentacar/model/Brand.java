package sample.rentacar.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Table(name = "brand")
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name= "name")
    private String name;

    @OneToMany(mappedBy = "brand" , cascade = CascadeType.ALL)
    private Set<Car> cars;
}
