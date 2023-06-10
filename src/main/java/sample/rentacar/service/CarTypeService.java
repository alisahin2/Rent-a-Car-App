package sample.rentacar.service;

import org.springframework.data.jpa.domain.Specification;
import sample.rentacar.dto.CarTypeDto;
import sample.rentacar.model.CarType;

import java.util.List;

public interface CarTypeService {
    List<CarTypeDto> getAll(Specification<CarType> spec);

    CarTypeDto save(CarTypeDto carTypeDto);

    CarTypeDto update(CarTypeDto carTypeDto);

    void delete(Long id);
}
