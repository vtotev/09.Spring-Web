package softuni.photostore.model.entity.lenses;

import softuni.photostore.model.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lens_brands")
public class LensBrand extends BaseEntity {

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brandName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private List<LensModel> lenses;

    public LensBrand() {
    }

    public String getBrandName() {
        return brandName;
    }

    public LensBrand setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}
