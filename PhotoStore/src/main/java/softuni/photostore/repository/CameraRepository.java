package softuni.photostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.photostore.model.entity.cameras.CameraModel;

@Repository
public interface CameraRepository extends JpaRepository<CameraModel, String> {



}
