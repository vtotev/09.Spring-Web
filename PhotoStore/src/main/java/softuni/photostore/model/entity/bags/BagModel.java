package softuni.photostore.model.entity.bags;

import softuni.photostore.model.entity.BaseEntity;
import softuni.photostore.model.entity.PictureEntity;
import softuni.photostore.model.entity.enums.BagTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "bags")
public class BagModel extends BaseEntity {

    @ManyToOne
    private BagBrand brand;

    @Column(nullable = false)
    private String modelName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BagTypeEnum bagType;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    private PictureEntity pictures;

    public BagModel() {
    }

    public BagBrand getBrand() {
        return brand;
    }

    public BagModel setBrand(BagBrand brand) {
        this.brand = brand;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public BagModel setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public BagTypeEnum getBagType() {
        return bagType;
    }

    public BagModel setBagType(BagTypeEnum bagType) {
        this.bagType = bagType;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BagModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BagModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BagModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public PictureEntity getPictures() {
        return pictures;
    }

    public BagModel setPictures(PictureEntity pictures) {
        this.pictures = pictures;
        return this;
    }
}
