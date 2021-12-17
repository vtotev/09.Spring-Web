package softuni.photostore.model.binding;

import org.springframework.web.multipart.MultipartFile;
import softuni.photostore.model.entity.enums.CameraSensorSizeEnum;
import softuni.photostore.model.entity.enums.LensMountTypeEnum;
import softuni.photostore.model.entity.enums.LensTypeEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class LensAddBindingModel {

    @NotBlank
    private String brand;

    @NotBlank
    @Size(min = 3)
    private String lensName;

    @NotBlank
    private String cameraBrandCompatibility;

    @NotNull
    private LensMountTypeEnum cameraTypeCompatibility;

    @NotNull
    private CameraSensorSizeEnum sensorSizeCompatibility;

    @NotNull
    private LensTypeEnum lensType;


    @NotNull
    @Min(value = 0)
    private Double fastestAperture;

    @NotNull
    @Min(value = 0)
    private BigDecimal price;

    @NotNull
    @Min(value = 0)
    private Integer quantity;

    @NotBlank
    @Size(min = 10)
    private String description;

    private MultipartFile picture;

    public String getBrand() {
        return brand;
    }

    public LensAddBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getLensName() {
        return lensName;
    }

    public LensAddBindingModel setLensName(String lensName) {
        this.lensName = lensName;
        return this;
    }

    public String getCameraBrandCompatibility() {
        return cameraBrandCompatibility;
    }

    public LensAddBindingModel setCameraBrandCompatibility(String cameraBrandCompatibility) {
        this.cameraBrandCompatibility = cameraBrandCompatibility;
        return this;
    }

    public LensMountTypeEnum getCameraTypeCompatibility() {
        return cameraTypeCompatibility;
    }

    public LensAddBindingModel setCameraTypeCompatibility(LensMountTypeEnum cameraTypeCompatibility) {
        this.cameraTypeCompatibility = cameraTypeCompatibility;
        return this;
    }

    public CameraSensorSizeEnum getSensorSizeCompatibility() {
        return sensorSizeCompatibility;
    }

    public LensAddBindingModel setSensorSizeCompatibility(CameraSensorSizeEnum sensorSizeCompatibility) {
        this.sensorSizeCompatibility = sensorSizeCompatibility;
        return this;
    }

    public LensTypeEnum getLensType() {
        return lensType;
    }

    public LensAddBindingModel setLensType(LensTypeEnum lensType) {
        this.lensType = lensType;
        return this;
    }

    public Double getFastestAperture() {
        return fastestAperture;
    }

    public LensAddBindingModel setFastestAperture(Double fastestAperture) {
        this.fastestAperture = fastestAperture;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LensAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LensAddBindingModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public LensAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public LensAddBindingModel setPicture(MultipartFile picture) {
        this.picture = picture;
        return this;
    }
}