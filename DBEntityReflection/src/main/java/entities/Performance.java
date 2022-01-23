package entities;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class Performance {

    //AS_OF_VALUATION_DATE	TIMESTAMP_NTZ(9)
    @SerializedName(value = "AS_OF_VALUATION_DATE")
    private LocalDateTime asOfValuationDate;

    //ASSET_ID	VARCHAR(16777216)
    @SerializedName(value = "ASSET_ID")
    private String assetId;

    //ASSET_NAME	VARCHAR(16777216)
    @SerializedName(value = "ASSET_NAME")
    private String assetName;

    //cusip	VARCHAR(16777216)
    @SerializedName(value = "cusip")
    private String cusip;

    //isin	VARCHAR(16777216)
    @SerializedName(value = "isin")
    private String isin;

    //sedol	VARCHAR(16777216)
    @SerializedName(value = "sedol")
    private String sedol;

    //PROFIT_AND_LOSS_BY_DAY_1	VARCHAR(16777216)
    @SerializedName(value = "PROFIT_AND_LOSS_BY_DAY_1")
    private String profitAndLossByDayOne;

    public Performance() {
    }

    public LocalDateTime getAsOfValuationDate() {
        return asOfValuationDate;
    }

    public Performance setAsOfValuationDate(LocalDateTime asOfValuationDate) {
        this.asOfValuationDate = asOfValuationDate;
        return this;
    }

    public String getAssetId() {
        return assetId;
    }

    public Performance setAssetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    public String getAssetName() {
        return assetName;
    }

    public Performance setAssetName(String assetName) {
        this.assetName = assetName;
        return this;
    }

    public String getCusip() {
        return cusip;
    }

    public Performance setCusip(String cusip) {
        this.cusip = cusip;
        return this;
    }

    public String getIsin() {
        return isin;
    }

    public Performance setIsin(String isin) {
        this.isin = isin;
        return this;
    }

    public String getSedol() {
        return sedol;
    }

    public Performance setSedol(String sedol) {
        this.sedol = sedol;
        return this;
    }

    public String getProfitAndLossByDayOne() {
        return profitAndLossByDayOne;
    }

    public Performance setProfitAndLossByDayOne(String profitAndLossByDayOne) {
        this.profitAndLossByDayOne = profitAndLossByDayOne;
        return this;
    }
}
