package sample.rentacar.model;

import lombok.*;
import sample.rentacar.model.enums.FuelType;
import sample.rentacar.model.enums.GearType;

import javax.persistence.*;

@Table(name = "car")
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name= "color")
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type")
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "gear_type")
    private GearType gearType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id" , referencedColumnName = "id", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id" , referencedColumnName = "id", nullable = false)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_type_id" , referencedColumnName = "id", nullable = false)
    private CarType carType;

}
