package softuni.photostore.model.entity.tripods;

import softuni.photostore.model.entity.BaseEntity;
import softuni.photostore.model.entity.PictureEntity;
import softuni.photostore.model.entity.cameras.CameraBrand;
import softuni.photostore.model.entity.enums.CameraSensorSizeEnum;
import softuni.photostore.model.entity.enums.CameraTypeEnum;
import softuni.photostore.model.entity.enums.LensTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tripod_models")
public class TripodModel extends BaseEntity {

    @ManyToOne
    private TripodBrand brand;

    @Column(name = "tripod_name", nullable = false)
    private String tripodName;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    private PictureEntity pictures;

    public TripodModel() {
    }

    public TripodBrand getBrand() {
        return brand;
    }

    public TripodModel setBrand(TripodBrand brand) {
        this.brand = brand;
        return this;
    }

    public String getTripodName() {
        return tripodName;
    }

    public TripodModel setTripodName(String tripodName) {
        this.tripodName = tripodName;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TripodModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public TripodModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TripodModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public PictureEntity getPictures() {
        return pictures;
    }

    public TripodModel setPictures(PictureEntity pictures) {
        this.pictures = pictures;
        return this;
    }
}
