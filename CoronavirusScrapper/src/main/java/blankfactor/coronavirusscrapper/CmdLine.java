package blankfactor.coronavirusscrapper;

import blankfactor.coronavirusscrapper.entity.Continent;
import blankfactor.coronavirusscrapper.entity.Country;
import blankfactor.coronavirusscrapper.service.ContinentService;
import blankfactor.coronavirusscrapper.service.CountryService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CmdLine implements CommandLineRunner {

    private final CountryService countryService;
    private final ContinentService continentService;
    private static final DecimalFormatSymbols dfSymbol = new DecimalFormatSymbols();

    static {
        dfSymbol.setGroupingSeparator(',');
    }

    private static final DecimalFormat df = new DecimalFormat("###,###,###", dfSymbol);

    public CmdLine(CountryService countryService, ContinentService continentService) {
        this.countryService = countryService;
        this.continentService = continentService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        List<Element> elements = readDataFromWebsite();
        LocalDate currDate = LocalDate.now();

//        if (!countryService.isDateAdded(currDate) && ((elements != null) && !elements.isEmpty())) {
        if ((elements != null) && !elements.isEmpty()) {
            elements.forEach(element ->
                    countryService.addOrUpdateCountry(element, currDate));
        }

        System.out.print("region=");
        String region = scanner.nextLine();
        if (region.isBlank()) {
            List<Country> allCountries = countryService.findAllForToday()
                    .stream().sorted((o1, o2) -> {
                        int i = o1.getContinent().getContinentName().compareTo(o2.getContinent().getContinentName());
                        if (i == 0) {
                            return o1.getCountry().compareTo(o2.getCountry());
                        }
                        return i;
                    })
                    .collect(Collectors.toList());
            printAsTable(allCountries);

        } else {
            Continent continentByName = continentService.getContinentByNameAndDate(region, currDate);
            if (continentByName != null) {
                List<Country> countries = continentByName
                        .getCountries()
                        .stream()
                        .sorted(Comparator.comparing(Country::getCountry))
                        .collect(Collectors.toList());
                printAsTable(countries);
                exportRegionToCSV(region, countries);
            }
        }
    }

    private void exportRegionToCSV(String region, List<Country> countries) {
        String csvFileName = String.format("export_%s_%s.csv",
                region.replaceAll("/", ""), LocalDate.now().format(DateTimeFormatter.ofPattern("yy_MM_dd")));
        File csvOutputFile = new File(csvFileName);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            countries.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String convertToCSV(Country country) {
        return String.format("%s, %s, %s, %s, %s",
                country.getContinent().getContinentName(),
                country.getCountry(),
                checkValue(country.getTotalCases()),
                checkValue(country.getTotalTests()),
                checkValue(country.getActiveCases()));
    }

    private String checkValue(Long value) {

        return value != null ? df.format(value) : "N/A";
    }

    private List<Element> readDataFromWebsite() {
        try {
            Document covid = Jsoup.connect("https://www.worldometers.info/coronavirus/").get();
            Element mainTable = covid.getElementById("main_table_countries_today");
            Element tbody = mainTable.select("tbody").first();
            Elements tr = tbody.select("tr");
            return tr.stream().skip(8).collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }

    private void printAsTable(List<Country> countries) {
        int continentLength = continentService.getMaxContinentNameLength();
        int countryLength = countryService.getMaxCountryNameLength();
        StringBuilder sb = new StringBuilder()
                .append("| %").append(continentLength).append("s | ")
                .append("%").append(countryLength).append("s | ")
                .append("%12s | ").append("%12s | ").append("%12s |").append(System.lineSeparator());
        String firstRow = String.format(sb.toString(), "Continent", "Country", "Total cases", "Total tests", "Active cases");
        String lineSeparator = "-".repeat(firstRow.length() - 2);
        System.out.printf("%s%n%s%s%n", lineSeparator, firstRow, lineSeparator);
        if (!countries.isEmpty()) {
            countries.forEach(country -> System.out.printf(sb.toString(),
                    country.getContinent().getContinentName(),
                    country.getCountry(),
                    checkValue(country.getTotalCases()),
                    checkValue(country.getTotalTests()),
                    checkValue(country.getActiveCases())));
            System.out.println(lineSeparator);
        }
    }
}