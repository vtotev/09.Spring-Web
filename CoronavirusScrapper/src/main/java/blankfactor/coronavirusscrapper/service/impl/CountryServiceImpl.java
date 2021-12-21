package blankfactor.coronavirusscrapper.service.impl;

import blankfactor.coronavirusscrapper.entity.Continent;
import blankfactor.coronavirusscrapper.entity.Country;
import blankfactor.coronavirusscrapper.repository.CountryRepository;
import blankfactor.coronavirusscrapper.service.ContinentService;
import blankfactor.coronavirusscrapper.service.CountryService;
import org.springframework.stereotype.Service;
import org.jsoup.nodes.Element;

import java.time.LocalDate;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final ContinentService continentService;
    private final CountryRepository repository;

    public CountryServiceImpl(ContinentService continentService, CountryRepository repository) {
        this.continentService = continentService;
        this.repository = repository;
    }

    @Override
    public void addCountry(Element data, LocalDate dateAdded) {
        String countryName = data.child(1).text();
        String continentName = data.child(15).text();
        Long totalCases = getValueAsInt(data.child(2).text());
        Long totalTests = getValueAsInt(data.child(12).text());
        Long activeCases = getValueAsInt(data.child(8).text());
        Continent continent = continentService.addOrGetContinent(continentName);
        Country country = new Country()
                .setCountry(countryName)
                .setActiveCases(activeCases)
                .setTotalCases(totalCases)
                .setTotalTests(totalTests)
                .setDateAdded(dateAdded)
                .setContinent(continent);
        repository.save(country);
    }

    @Override
    public boolean isDateAdded(LocalDate date) {
        return repository.findAllByDateAdded(date).size() > 0;
    }

    @Override
    public List<Country> findAllForToday() {
        return repository.findAllByDateAdded(LocalDate.now());
    }

    @Override
    public Integer getMaxCountryNameLength() {
        return repository.getMaxCountryLength();
    }

    private static Long getValueAsInt(String value) {
        try {
            return Long.parseLong(value.replaceAll(",", ""));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
