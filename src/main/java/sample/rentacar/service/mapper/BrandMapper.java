package sample.rentacar.service.mapper;

import sample.rentacar.dto.BrandDto;
import sample.rentacar.model.Brand;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {CarMapper.class})
public interface BrandMapper {
    BrandDto toDto(Brand brand);

    Brand toEntity(BrandDto brandDto);
}
