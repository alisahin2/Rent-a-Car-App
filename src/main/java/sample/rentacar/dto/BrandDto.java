package sample.rentacar.dto;

import lombok.Data;

import java.util.Set;

@Data
public class BrandDto {

    private Long id;
    private String name;
    private Set<CarDto> cars;
}
