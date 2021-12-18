package blankfactor.coronavirusscrapper.service;

import blankfactor.coronavirusscrapper.entity.Continent;

public interface ContinentService {
    Continent addOrGetContinent(String continentName);
    Integer getMaxContinentNameLength();
    Continent getContinentByName(String continentName);
}
