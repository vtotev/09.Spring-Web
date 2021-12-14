package softuni.photostore.service;

import softuni.photostore.model.binding.CameraBrandAddBindingModel;
import softuni.photostore.model.entity.cameras.CameraBrand;

import java.util.List;

public interface CameraBrandsService {
    boolean registerNewBrand(CameraBrandAddBindingModel brand);
    List<CameraBrand> getAllBrands();
    boolean isBrandExisting(String brand);
    void deleteBrandWithId(String id);
    CameraBrand getBrandByName(String name);
}
