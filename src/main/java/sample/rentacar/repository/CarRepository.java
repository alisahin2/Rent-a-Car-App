package sample.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.rentacar.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
