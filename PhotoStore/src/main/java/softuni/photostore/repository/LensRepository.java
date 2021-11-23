package softuni.photostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.photostore.model.entity.lenses.LensModel;

@Repository
public interface LensRepository extends JpaRepository<LensModel, String> {


}
