package softuni.photostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.photostore.model.entity.tripods.TripodModel;

import java.util.Collection;
import java.util.List;

@Repository
public interface TripodRepository extends JpaRepository<TripodModel, String> {


    @Query(value = "select * from tripod_models t where " +
            "(:brandName IS NULL or t.brand_id = :brandName) and " +
            "(:priceFrom IS NULL or t.price >= :priceFrom) and " +
            "(:priceTo IS NULL or t.price <= :priceTo)"
            , nativeQuery = true)
    List<TripodModel> findAllByFilterCriteria(@Param("brandName") String brandName,
                                              @Param("priceFrom") Integer priceFrom,
                                              @Param("priceTo") Integer priceTo);
}
