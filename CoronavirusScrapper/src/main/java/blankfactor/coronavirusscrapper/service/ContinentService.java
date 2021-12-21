package blankfactor.coronavirusscrapper.service;

import blankfactor.coronavirusscrapper.entity.Continent;

import java.time.LocalDate;

public interface ContinentService {
    Continent addOrGetContinent(String continentName);
    Integer getMaxContinentNameLength();
    Continent getContinentByNameAndDate(String continentName, LocalDate date);
}
