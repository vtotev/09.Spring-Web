package softuni.photostore.model.entity.cameras;

import softuni.photostore.model.entity.BaseEntity;
import softuni.photostore.model.entity.enums.CameraSensorSizeEnum;
import softuni.photostore.model.entity.enums.CameraTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "camera_models")
public class CameraModel extends BaseEntity {

    @ManyToOne
    private CameraBrand brand;

    @Column(name = "camera_name", nullable = false)
    private String cameraName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CameraTypeEnum cameraType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CameraSensorSizeEnum sensorSize;

    @Column(nullable = false)
    private Integer megapixels;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany
    private List<CameraPicture> pictures;

    public CameraModel() {
    }

    public CameraBrand getBrand() {
        return brand;
    }

    public CameraModel setBrand(CameraBrand brand) {
        this.brand = brand;
        return this;
    }

    public String getCameraName() {
        return cameraName;
    }

    public CameraModel setCameraName(String cameraName) {
        this.cameraName = cameraName;
        return this;
    }

    public CameraTypeEnum getCameraType() {
        return cameraType;
    }

    public CameraModel setCameraType(CameraTypeEnum cameraType) {
        this.cameraType = cameraType;
        return this;
    }

    public CameraSensorSizeEnum getSensorSize() {
        return sensorSize;
    }

    public CameraModel setSensorSize(CameraSensorSizeEnum sensorSize) {
        this.sensorSize = sensorSize;
        return this;
    }

    public Integer getMegapixels() {
        return megapixels;
    }

    public CameraModel setMegapixels(Integer megapixels) {
        this.megapixels = megapixels;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CameraModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public CameraModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CameraModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<CameraPicture> getPictures() {
        return pictures;
    }

    public CameraModel setPictures(List<CameraPicture> pictures) {
        this.pictures = pictures;
        return this;
    }
}
