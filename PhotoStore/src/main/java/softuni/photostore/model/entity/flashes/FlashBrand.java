package softuni.photostore.model.entity.flashes;

import softuni.photostore.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "flash_brands")
public class FlashBrand extends BaseEntity {

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private List<FlashModel> flashes;

    public FlashBrand() {
    }

    public String getBrandName() {
        return brandName;
    }

    public FlashBrand setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public List<FlashModel> getFlashes() {
        return flashes;
    }

    public FlashBrand setFlashes(List<FlashModel> flashes) {
        this.flashes = flashes;
        return this;
    }
}