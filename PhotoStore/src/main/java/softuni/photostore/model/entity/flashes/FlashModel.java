package softuni.photostore.model.entity.flashes;

import softuni.photostore.model.entity.BaseEntity;
import softuni.photostore.model.entity.PictureEntity;
import softuni.photostore.model.entity.cameras.CameraBrand;
import softuni.photostore.model.entity.enums.CameraSensorSizeEnum;
import softuni.photostore.model.entity.enums.CameraTypeEnum;
import softuni.photostore.model.entity.enums.FlashModesEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "flash_models")
public class FlashModel extends BaseEntity {

    @ManyToOne
    private FlashBrand brand;

    @Column(name = "flash_name", nullable = false)
    private String flashName;

    @ManyToOne
    private CameraBrand brandCompatibility;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlashModesEnum flashType;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Boolean isHSS;

    @OneToOne
    private PictureEntity pictures;

    public FlashModel() {
    }

    public FlashBrand getBrand() {
        return brand;
    }

    public FlashModel setBrand(FlashBrand brand) {
        this.brand = brand;
        return this;
    }

    public String getFlashName() {
        return flashName;
    }

    public FlashModel setFlashName(String flashName) {
        this.flashName = flashName;
        return this;
    }

    public CameraBrand getBrandCompatibility() {
        return brandCompatibility;
    }

    public FlashModel setBrandCompatibility(CameraBrand brandCompatibility) {
        this.brandCompatibility = brandCompatibility;
        return this;
    }

    public FlashModesEnum getFlashType() {
        return flashType;
    }

    public FlashModel setFlashType(FlashModesEnum flashType) {
        this.flashType = flashType;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public FlashModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public FlashModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FlashModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getHSS() {
        return isHSS;
    }

    public FlashModel setHSS(Boolean HSS) {
        isHSS = HSS;
        return this;
    }

    public PictureEntity getPictures() {
        return pictures;
    }

    public FlashModel setPictures(PictureEntity pictures) {
        this.pictures = pictures;
        return this;
    }
}
