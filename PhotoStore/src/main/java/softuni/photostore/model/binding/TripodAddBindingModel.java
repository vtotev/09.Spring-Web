package softuni.photostore.model.binding;

import org.springframework.web.multipart.MultipartFile;
import softuni.photostore.model.entity.PictureEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class TripodAddBindingModel {

    @NotBlank
    private String brand;

    @NotBlank
    @Size(min = 3)
    private String tripodName;

    @NotNull
    @Min(value = 0)
    private BigDecimal price;

    @NotNull
    @Min(value = 0)
    private Integer quantity;

    @NotBlank
    @Size(min = 10)
    private String description;

    private MultipartFile pictures;

    public TripodAddBindingModel() {
    }

    public String getBrand() {
        return brand;
    }

    public TripodAddBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getTripodName() {
        return tripodName;
    }

    public TripodAddBindingModel setTripodName(String tripodName) {
        this.tripodName = tripodName;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TripodAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public TripodAddBindingModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TripodAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getPictures() {
        return pictures;
    }

    public TripodAddBindingModel setPictures(MultipartFile pictures) {
        this.pictures = pictures;
        return this;
    }
}
