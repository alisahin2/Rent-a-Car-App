package sample.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.rentacar.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
