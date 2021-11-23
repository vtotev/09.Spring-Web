package softuni.photostore.model.entity.bags;

import softuni.photostore.model.entity.BaseEntity;
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

    @OneToMany
    private List<BagPicture> pictures;

    public BagModel() {
    }

    public BagBrand getBrand() {
        return brand;
    }

    public BagModel setBrand(BagBrand brand) {
        this.brand = brand;
        return this;
    }
}
