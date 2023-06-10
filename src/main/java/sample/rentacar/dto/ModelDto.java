package sample.rentacar.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ModelDto {
    private Long id;
    private String name;
    private Set<CarDto> cars;
}
