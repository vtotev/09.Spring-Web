package softuni.photostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.photostore.model.entity.bags.BagModel;

@Repository
public interface BagsRepository extends JpaRepository<BagModel, String> {


}
