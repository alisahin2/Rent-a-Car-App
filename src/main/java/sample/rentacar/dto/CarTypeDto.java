package sample.rentacar.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CarTypeDto {
    private Long id;
    private String type;
    private Set<CarDto> cars;
}
