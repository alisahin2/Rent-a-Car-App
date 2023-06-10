package sample.rentacar.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sample.rentacar.dto.CarDto;
import sample.rentacar.model.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(source = "carType.id" , target = "carTypeId")
    @Mapping(source = "model.id" , target = "modelId")
    @Mapping(source = "brand.id" , target = "brandId")
    CarDto toDto(Car car);

    @Mapping(source = "carTypeId" , target = "carType.id")
    @Mapping(source = "modelId" , target = "model.id")
    @Mapping(source = "brandId" , target = "brand.id")
    Car toEntity(CarDto carDto);
}
