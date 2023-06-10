package sample.rentacar.service;

import org.springframework.data.jpa.domain.Specification;
import sample.rentacar.dto.BrandDto;
import sample.rentacar.model.Brand;

import java.util.List;

public interface BrandService {

    List<BrandDto> getAll(Specification<Brand> spec);

    BrandDto save(BrandDto brandDto);

    BrandDto update(BrandDto brandDto);

    void delete(Long id);
}
