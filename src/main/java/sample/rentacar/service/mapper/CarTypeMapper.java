package sample.rentacar.service.mapper;

import org.mapstruct.Mapper;
import sample.rentacar.dto.CarTypeDto;
import sample.rentacar.model.CarType;

@Mapper(componentModel = "spring", uses = {CarMapper.class})
public interface CarTypeMapper {

    CarTypeDto toDto(CarType carType);
    CarType toEntity(CarTypeDto carTypeDto);
}
