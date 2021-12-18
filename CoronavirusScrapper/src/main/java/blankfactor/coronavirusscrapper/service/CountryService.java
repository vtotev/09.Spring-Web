package blankfactor.coronavirusscrapper.service;

import blankfactor.coronavirusscrapper.entity.Country;
import org.jsoup.nodes.Element;

import java.time.LocalDate;
import java.util.List;

public interface CountryService {
    void addCountry(Element data, LocalDate dateAdded);
    boolean isDateAdded(LocalDate date);
    List<Country> findAll();
    Integer getMaxCountryNameLength();
}
