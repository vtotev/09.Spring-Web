package blankfactor.coronavirusscrapper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Country extends BaseEntity {
    private String country;
    private Long totalCases;
    private Long activeCases;
    private Long totalTests;
    private LocalDate dateAdded;

    @ManyToOne
    private Continent continent;

    public Country() {
    }

    public String getCountry() {
        return country;
    }

    public Country setCountry(String country) {
        this.country = country;
        return this;
    }

    public Long getTotalCases() {
        return totalCases;
    }

    public Country setTotalCases(Long totalCases) {
        this.totalCases = totalCases;
        return this;
    }

    public Long getActiveCases() {
        return activeCases;
    }

    public Country setActiveCases(Long activeCases) {
        this.activeCases = activeCases;
        return this;
    }

    public Long getTotalTests() {
        return totalTests;
    }

    public Country setTotalTests(Long totalTests) {
        this.totalTests = totalTests;
        return this;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public Country setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
        return this;
    }

    public Continent getContinent() {
        return continent;
    }

    public Country setContinent(Continent continent) {
        this.continent = continent;
        return this;
    }
}
