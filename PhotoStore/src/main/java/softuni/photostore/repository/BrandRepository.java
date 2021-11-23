package softuni.photostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.photostore.model.entity.cameras.CameraBrand;

@Repository
public interface BrandRepository extends JpaRepository<CameraBrand, String> {

}
