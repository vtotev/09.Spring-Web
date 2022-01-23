package entities;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Store {
    @SerializedName(value = "S_STORE_SK")
    private Long storeSK;
    
    @SerializedName(value = "S_STORE_ID")
    private String storeId;

    @SerializedName(value = "S_REC_START_DATE")
    private LocalDate recStartDate;

    @SerializedName(value = "S_REC_END_DATE")
    private LocalDate recEndDate;

    @SerializedName(value = "S_CLOSED_DATE_SK")
    private Long closedDateSk;

    @SerializedName(value = "S_STORE_NAME")
    private String storeName;

    @SerializedName(value = "S_NUMBER_EMPLOYEES")
    private Long numberEmployees;

    @SerializedName(value = "S_FLOOR_SPACE")
    private Long floorSpace;

    @SerializedName(value = "S_HOURS")
    private String hours;

    @SerializedName(value = "S_MANAGER")
    private String manager;

    @SerializedName(value = "S_MARKET_ID")
    private Long marketId;

    @SerializedName(value = "S_GEOGRAPHY_CLASS")
    private String geographyClass;

    @SerializedName(value = "S_MARKET_DESC")
    private String marketDesc;

    @SerializedName(value = "S_MARKET_MANAGER")
    private String marketManager;

    @SerializedName(value = "S_DIVISION_ID")
    private Long divisionId;

    @SerializedName(value = "S_DIVISION_NAME")
    private String divisionName;

    @SerializedName(value = "S_COMPANY_ID")
    private Long companyId;

    @SerializedName(value = "S_COMPANY_NAME")
    private String companyName;

    @SerializedName(value = "S_STREET_NUMBER")
    private Long streetNumber;

    @SerializedName(value = "S_STREET_NAME")
    private String streetName;

    @SerializedName(value = "S_STREET_TYPE")
    private String streetType;

    @SerializedName(value = "S_SUITE_NUMBER")
    private String suiteNumber;

    @SerializedName(value = "S_CITY")
    private String city;

    @SerializedName(value = "S_COUNTY")
    private String county;

    @SerializedName(value = "S_STATE")
    private String state;

    @SerializedName(value = "S_ZIP")
    private Long zip;

    @SerializedName(value = "S_COUNTRY")
    private String country;

    @SerializedName(value = "S_GMT_OFFSET")
    private Double gmtOffset;

    @SerializedName(value = "S_TAX_PRECENTAGE")
    private Double taxPercentage;

    public Store() {
    }

    public Long getStoreSK() {
        return storeSK;
    }

    public Store setStoreSK(Long storeSK) {
        this.storeSK = storeSK;
        return this;
    }

    public String getStoreId() {
        return storeId;
    }

    public Store setStoreId(String storeId) {
        this.storeId = storeId;
        return this;
    }

    public LocalDate getRecStartDate() {
        return recStartDate;
    }

    public Store setRecStartDate(LocalDate recStartDate) {
        this.recStartDate = recStartDate;
        return this;
    }

    public LocalDate getRecEndDate() {
        return recEndDate;
    }

    public Store setRecEndDate(LocalDate recEndDate) {
        this.recEndDate = recEndDate;
        return this;
    }

    public Long getClosedDateSk() {
        return closedDateSk;
    }

    public Store setClosedDateSk(Long closedDateSk) {
        this.closedDateSk = closedDateSk;
        return this;
    }

    public String getStoreName() {
        return storeName;
    }

    public Store setStoreName(String storeName) {
        this.storeName = storeName;
        return this;
    }

    public Long getNumberEmployees() {
        return numberEmployees;
    }

    public Store setNumberEmployees(Long numberEmployees) {
        this.numberEmployees = numberEmployees;
        return this;
    }

    public Long getFloorSpace() {
        return floorSpace;
    }

    public Store setFloorSpace(Long floorSpace) {
        this.floorSpace = floorSpace;
        return this;
    }

    public String getHours() {
        return hours;
    }

    public Store setHours(String hours) {
        this.hours = hours;
        return this;
    }

    public String getManager() {
        return manager;
    }

    public Store setManager(String manager) {
        this.manager = manager;
        return this;
    }

    public Long getMarketId() {
        return marketId;
    }

    public Store setMarketId(Long marketId) {
        this.marketId = marketId;
        return this;
    }

    public String getGeographyClass() {
        return geographyClass;
    }

    public Store setGeographyClass(String geographyClass) {
        this.geographyClass = geographyClass;
        return this;
    }

    public String getMarketDesc() {
        return marketDesc;
    }

    public Store setMarketDesc(String marketDesc) {
        this.marketDesc = marketDesc;
        return this;
    }

    public String getMarketManager() {
        return marketManager;
    }

    public Store setMarketManager(String marketManager) {
        this.marketManager = marketManager;
        return this;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public Store setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public Store setDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Store setCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Store setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Long getStreetNumber() {
        return streetNumber;
    }

    public Store setStreetNumber(Long streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public Store setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getStreetType() {
        return streetType;
    }

    public Store setStreetType(String streetType) {
        this.streetType = streetType;
        return this;
    }

    public String getSuiteNumber() {
        return suiteNumber;
    }

    public Store setSuiteNumber(String suiteNumber) {
        this.suiteNumber = suiteNumber;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Store setCity(String city) {
        this.city = city;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public Store setCounty(String county) {
        this.county = county;
        return this;
    }

    public String getState() {
        return state;
    }

    public Store setState(String state) {
        this.state = state;
        return this;
    }

    public Long getZip() {
        return zip;
    }

    public Store setZip(Long zip) {
        this.zip = zip;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Store setCountry(String country) {
        this.country = country;
        return this;
    }

    public Double getGmtOffset() {
        return gmtOffset;
    }

    public Store setGmtOffset(Double gmtOffset) {
        this.gmtOffset = gmtOffset;
        return this;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public Store setTaxPercentage(Double taxPercentage) {
        this.taxPercentage = taxPercentage;
        return this;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeSK=" + storeSK +
                ", storeId='" + storeId + '\'' +
                ", recStartDate=" + recStartDate +
                ", recEndDate=" + recEndDate +
                ", closedDateSK=" + closedDateSk +
                ", storeName='" + storeName + '\'' +
                ", numberEmployees=" + numberEmployees +
                ", floorSpace=" + floorSpace +
                ", hours='" + hours + '\'' +
                ", manager='" + manager + '\'' +
                ", marketId=" + marketId +
                ", geographyClass='" + geographyClass + '\'' +
                ", marketDesc='" + marketDesc + '\'' +
                ", marketManager='" + marketManager + '\'' +
                ", divisionId=" + divisionId +
                ", divisionName='" + divisionName + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", streetType='" + streetType + '\'' +
                ", suiteNumber='" + suiteNumber + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", country='" + country + '\'' +
                ", gmtOffset=" + gmtOffset +
                ", taxPercentage=" + taxPercentage +
                '}';
    }
}

