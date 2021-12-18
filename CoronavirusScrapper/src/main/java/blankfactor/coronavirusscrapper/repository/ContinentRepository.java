package blankfactor.coronavirusscrapper.repository;

import blankfactor.coronavirusscrapper.entity.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
    @Query("select c from Continent c left join fetch c.countries countries where c.continentName=:continent")
    Optional<Continent> findByContinentName(@Param("continent") String continentName);

    @Query("select max(length(c.continentName)) from Continent c")
    Integer getMaxContinentLength();

}
