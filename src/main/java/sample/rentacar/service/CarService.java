package sample.rentacar.service;

import org.springframework.data.jpa.domain.Specification;
import sample.rentacar.dto.CarDto;
import sample.rentacar.model.Car;

import java.util.List;

public interface CarService {
    List<CarDto> getAll(Specification<Car> spec);

    CarDto save(CarDto carDto);

    CarDto update(CarDto carDto);

    void delete(Long id);
}
