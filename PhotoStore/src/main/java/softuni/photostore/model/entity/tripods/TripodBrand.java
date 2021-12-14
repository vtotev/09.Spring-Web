package softuni.photostore.model.entity.tripods;

import softuni.photostore.model.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tripod_brands")
public class TripodBrand extends BaseEntity {

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brandName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private List<TripodModel> tripods;

    public TripodBrand() {
    }

    public String getBrandName() {
        return brandName;
    }

    public TripodBrand setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public List<TripodModel> getTripods() {
        return tripods;
    }

    public TripodBrand setTripods(List<TripodModel> tripods) {
        this.tripods = tripods;
        return this;
    }
}
