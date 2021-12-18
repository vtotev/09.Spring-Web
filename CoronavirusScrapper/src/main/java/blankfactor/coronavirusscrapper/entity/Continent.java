package blankfactor.coronavirusscrapper.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Continent extends BaseEntity{

    private String continentName;

    @OneToMany(mappedBy = "continent")
    @Fetch(FetchMode.JOIN)
    private List<Country> countries;

    public Continent() {
    }

    public String getContinentName() {
        return continentName;
    }

    public Continent setContinentName(String continentName) {
        this.continentName = continentName;
        return this;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public Continent setCountries(List<Country> countries) {
        this.countries = countries;
        return this;
    }
}
