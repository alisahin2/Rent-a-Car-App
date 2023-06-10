package sample.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.rentacar.model.CarType;

public interface CarTypeRepository extends JpaRepository<CarType, Long> {
}
