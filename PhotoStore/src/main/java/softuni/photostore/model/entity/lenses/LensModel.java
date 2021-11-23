package softuni.photostore.model.entity.lenses;

import softuni.photostore.model.entity.BaseEntity;
import softuni.photostore.model.entity.cameras.CameraBrand;
import softuni.photostore.model.entity.enums.CameraSensorSizeEnum;
import softuni.photostore.model.entity.enums.CameraTypeEnum;
import softuni.photostore.model.entity.enums.LensTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "camera_models")
public class LensModel extends BaseEntity {

    @ManyToOne
    private LensBrand brand;

    @Column(name = "lens_name", nullable = false)
    private String lensName;

    @ManyToOne
    private CameraBrand cameraBrandCompatibility;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CameraTypeEnum cameraTypeCompatibility;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CameraSensorSizeEnum sensorSizeCompatibility;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LensTypeEnum lensType;


    @Column(nullable = false)
    private Double fastestAperture;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany
    private List<LensPicture> pictures;

    public LensModel() {
    }

    public LensBrand getBrand() {
        return brand;
    }

    public LensModel setBrand(LensBrand brand) {
        this.brand = brand;
        return this;
    }

    public String getLensName() {
        return lensName;
    }

    public LensModel setLensName(String lensName) {
        this.lensName = lensName;
        return this;
    }

    public CameraBrand getCameraBrandCompatibility() {
        return cameraBrandCompatibility;
    }

    public LensModel setCameraBrandCompatibility(CameraBrand cameraBrandCompatibility) {
        this.cameraBrandCompatibility = cameraBrandCompatibility;
        return this;
    }

    public CameraTypeEnum getCameraTypeCompatibility() {
        return cameraTypeCompatibility;
    }

    public LensModel setCameraTypeCompatibility(CameraTypeEnum cameraTypeCompatibility) {
        this.cameraTypeCompatibility = cameraTypeCompatibility;
        return this;
    }

    public CameraSensorSizeEnum getSensorSizeCompatibility() {
        return sensorSizeCompatibility;
    }

    public LensModel setSensorSizeCompatibility(CameraSensorSizeEnum sensorSizeCompatibility) {
        this.sensorSizeCompatibility = sensorSizeCompatibility;
        return this;
    }

    public LensTypeEnum getLensType() {
        return lensType;
    }

    public LensModel setLensType(LensTypeEnum lensType) {
        this.lensType = lensType;
        return this;
    }

    public Double getFastestAperture() {
        return fastestAperture;
    }

    public LensModel setFastestAperture(Double fastestAperture) {
        this.fastestAperture = fastestAperture;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LensModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LensModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LensModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<LensPicture> getPictures() {
        return pictures;
    }

    public LensModel setPictures(List<LensPicture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
