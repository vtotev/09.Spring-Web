package softuni.photostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.photostore.model.entity.flashes.FlashModel;

@Repository
public interface FlashRepository extends JpaRepository<FlashModel, String> {


}
