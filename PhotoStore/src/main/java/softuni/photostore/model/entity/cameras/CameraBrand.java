package softuni.photostore.model.entity.cameras;

import softuni.photostore.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "camera_brands")
public class CameraBrand extends BaseEntity {

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brandName;

    @OneToMany
    private List<CameraModel> cameraModels;

    public CameraBrand() {
    }

    public String getBrandName() {
        return brandName;
    }

    public CameraBrand setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public List<CameraModel> getCameraModels() {
        return cameraModels;
    }

    public CameraBrand setCameraModels(List<CameraModel> cameraModels) {
        this.cameraModels = cameraModels;
        return this;
    }
}
