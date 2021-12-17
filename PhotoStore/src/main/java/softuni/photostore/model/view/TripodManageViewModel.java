package softuni.photostore.model.view;

import softuni.photostore.model.entity.PictureEntity;

import java.math.BigDecimal;

public class TripodManageViewModel {

    private String id;
    private String brand;
    private String tripodName;
    private BigDecimal price;
    private Integer quantity;

    public TripodManageViewModel() {
    }

    public String getId() {
        return id;
    }

    public TripodManageViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public TripodManageViewModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getTripodName() {
        return tripodName;
    }

    public TripodManageViewModel setTripodName(String tripodName) {
        this.tripodName = tripodName;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TripodManageViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public TripodManageViewModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

}
