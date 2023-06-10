package sample.rentacar.service.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import sample.rentacar.dto.ModelDto;
import sample.rentacar.model.Model;
import sample.rentacar.repository.ModelRepository;
import sample.rentacar.service.ModelService;
import sample.rentacar.service.mapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelDto> getAll(Specification<Model> spec) {
        List<Model> models = modelRepository.findAll();
        List<ModelDto> modelDtos = models
                .stream()
                .map(model -> modelMapper.toDto(model))
                .collect(Collectors.toList());
        return modelDtos;
    }

    @Override
    public ModelDto save(ModelDto modelDto) {
        Model model = modelRepository.save(modelMapper.toEntity(modelDto));
        modelDto = modelMapper.toDto(model);
        return modelDto;
    }

    @Override
    public ModelDto update(ModelDto modelDto) {
        Optional<Model> model = modelRepository.findById(modelDto.getId());
        if(!model.isPresent()){
            throw new NullPointerException();
        }
        modelDto = save(modelDto);
        return modelDto;
    }

    @Override
    public void delete(Long id) {
        Optional<Model> model = modelRepository.findById(id);
        if(!model.isPresent()){
            throw new NullPointerException();
        }
        modelRepository.delete(model.get());
    }

}
