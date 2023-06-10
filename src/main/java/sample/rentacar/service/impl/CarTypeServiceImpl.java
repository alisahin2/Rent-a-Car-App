package sample.rentacar.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import sample.rentacar.dto.CarTypeDto;
import sample.rentacar.model.CarType;
import sample.rentacar.repository.CarTypeRepository;
import sample.rentacar.service.CarTypeService;
import sample.rentacar.service.mapper.CarTypeMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarTypeServiceImpl implements CarTypeService {

    private final CarTypeRepository carTypeRepository;

    private final CarTypeMapper carTypeMapper;

    public CarTypeServiceImpl(CarTypeRepository carTypeRepository, CarTypeMapper carTypeMapper) {
        this.carTypeRepository = carTypeRepository;
        this.carTypeMapper = carTypeMapper;
    }


    @Override
    public List<CarTypeDto> getAll(Specification<CarType> spec) {

        List<CarType> carTypes = carTypeRepository.findAll();
        List<CarTypeDto> carTypeDtos = carTypes
                .stream()
                .map(carType -> carTypeMapper.toDto(carType))
                .collect(Collectors.toList());
        return carTypeDtos;
    }

    @Override
    public CarTypeDto save(CarTypeDto carTypeDto) {
        CarType carType = carTypeRepository.save(carTypeMapper.toEntity(carTypeDto));
        carTypeDto = carTypeMapper.toDto(carType);
        return carTypeDto;
    }

    @Override
    public CarTypeDto update(CarTypeDto carTypeDto) {
        Optional<CarType> carType = carTypeRepository.findById(carTypeDto.getId());
        if(!carType.isPresent()){
            throw new NullPointerException();
        }
        carTypeDto = save(carTypeDto);
        return carTypeDto;
    }

    @Override
    public void delete(Long id) {
        Optional<CarType> carType = carTypeRepository.findById(id);
        if(!carType.isPresent()){
            throw new NullPointerException();
        }
        carTypeRepository.delete(carType.get());
    }
}
