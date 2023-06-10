package sample.rentacar.service.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import sample.rentacar.dto.CarDto;
import sample.rentacar.model.Car;
import sample.rentacar.repository.CarRepository;
import sample.rentacar.service.CarService;
import sample.rentacar.service.mapper.CarMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarDto> getAll(Specification<Car> spec) {
        List<Car> cars = carRepository.findAll();
        List<CarDto> carDtos = cars
                .stream()
                .map(car -> carMapper.toDto(car))
                .collect(Collectors.toList());
        return carDtos;
    }

    @Override
    public CarDto save(CarDto carDto) {
        Car car = carRepository.save(carMapper.toEntity(carDto));
        carDto = carMapper.toDto(car);
        return carDto;
    }

    @Override
    public CarDto update(CarDto carDto) {
        Optional<Car> car = carRepository.findById(carDto.getId());
        if(!car.isPresent()){
            throw new NullPointerException();
        }
        carDto = save(carDto);
        return carDto;
    }

    @Override
    public void delete(Long id) {

        Optional<Car> car = carRepository.findById(id);
        if(!car.isPresent()){
            throw new NullPointerException();
        }
        carRepository.delete(car.get());
    }
}
