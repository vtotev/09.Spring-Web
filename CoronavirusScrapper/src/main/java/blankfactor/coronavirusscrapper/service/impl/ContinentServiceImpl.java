package blankfactor.coronavirusscrapper.service.impl;

import blankfactor.coronavirusscrapper.entity.Continent;
import blankfactor.coronavirusscrapper.repository.ContinentRepository;
import blankfactor.coronavirusscrapper.service.ContinentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContinentServiceImpl implements ContinentService {
    private final ContinentRepository continentRepository;

    public ContinentServiceImpl(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    @Override
    public Continent addOrGetContinent(String continentName) {
        return continentRepository.findByContinentName(continentName).orElseGet(() ->
            continentRepository.save(new Continent().setContinentName(continentName)));
    }

    @Override
    public Integer getMaxContinentNameLength() {
        return continentRepository.getMaxContinentLength();
    }

    @Override
    public Continent getContinentByNameAndDate(String continentName, LocalDate date) {
        return continentRepository.findByContinentNameAndDate(continentName, date).orElse(null);
    }


}
