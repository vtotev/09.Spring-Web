package blankfactor.coronavirusscrapper.repository;

import blankfactor.coronavirusscrapper.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAllByDateAdded(LocalDate dateAdded);

    @Query("select max(length(c.country)) from Country c")
    Integer getMaxCountryLength();

    Optional<Country> findByCountryAndDateAdded(String country, LocalDate dateAdded);
}
