package softuni.photostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.photostore.model.entity.tripods.TripodModel;

@Repository
public interface TripodRepository extends JpaRepository<TripodModel, String> {


}
