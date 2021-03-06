package softuni.photostore.model.view;

import softuni.photostore.model.entity.lenses.LensBrand;

import java.math.BigDecimal;

public class FlashManageViewModel {
    private String id;
    private LensBrand brand;
    private String modelName;
    private BigDecimal price;
    private Integer quantity;

    public FlashManageViewModel() {
    }

    public String getId() {
        return id;
    }

    public FlashManageViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public FlashManageViewModel setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public FlashManageViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public FlashManageViewModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public LensBrand getBrand() {
        return brand;
    }

    public FlashManageViewModel setBrand(LensBrand brand) {
        this.brand = brand;
        return this;
    }
}