package sample.rentacar.dto;

import lombok.Data;
import sample.rentacar.model.enums.FuelType;
import sample.rentacar.model.enums.GearType;

@Data
public class CarDto {
    private Long id;
    private String color;
    private FuelType fuelType;
    private GearType gearType;
    private Long brandId;
    private Long modelId;
    private Long carTypeId;
}
