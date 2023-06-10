package sample.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.rentacar.model.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
