package softuni.photostore.model.entity.bags;
import softuni.photostore.model.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bags_brands")
public class BagBrand extends BaseEntity {

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brandName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private List<BagModel> bags;

    public BagBrand() {
    }

    public String getBrandName() {
        return brandName;
    }

    public BagBrand setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public List<BagModel> getBags() {
        return bags;
    }

    public BagBrand setBags(List<BagModel> bags) {
        this.bags = bags;
        return this;
    }
}
