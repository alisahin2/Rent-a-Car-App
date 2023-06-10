package sample.rentacar.service;

import org.springframework.data.jpa.domain.Specification;
import sample.rentacar.dto.ModelDto;
import sample.rentacar.model.Model;

import java.util.List;

public interface ModelService {
    List<ModelDto> getAll(Specification<Model> spec);

    ModelDto save(ModelDto modelDto);

    ModelDto update(ModelDto modelDto);

    void delete(Long id);
}
