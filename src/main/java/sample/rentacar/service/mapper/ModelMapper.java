package sample.rentacar.service.mapper;

import org.mapstruct.Mapper;
import sample.rentacar.dto.ModelDto;
import sample.rentacar.model.Model;

@Mapper(componentModel = "spring" , uses = {CarMapper.class})
public interface ModelMapper {

    Model toEntity(ModelDto modelDto);

    ModelDto toDto(Model model);
}
