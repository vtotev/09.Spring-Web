package softuni.photostore.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BagBrandAddBindingModel {
    @NotBlank
    @Size(min = 3, max = 20)
    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public BagBrandAddBindingModel setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}
