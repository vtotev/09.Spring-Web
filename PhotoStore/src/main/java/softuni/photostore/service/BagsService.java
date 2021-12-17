package softuni.photostore.service;

import softuni.photostore.model.binding.BagAddBindingModel;
import softuni.photostore.model.binding.BagBrandAddBindingModel;
import softuni.photostore.model.binding.BagEditBindingModel;
import softuni.photostore.model.entity.bags.BagBrand;
import softuni.photostore.model.entity.bags.BagModel;
import softuni.photostore.model.service.BagFilterModel;
import softuni.photostore.model.view.BagManageViewModel;
import softuni.photostore.model.view.BagViewModel;

import java.util.List;

public interface BagsService {

    // BRAND METHODS

    List<BagBrand> getAllBrands();

    boolean isBrandExisting(String brandName);

    boolean registerNewBrand(BagBrandAddBindingModel brand);

    void deleteBrandWithId(String id);

    BagBrand getBrandByName(String brand);


    // MODEL METHODS

    List<BagManageViewModel> getAllBagsForManagement();

    boolean addNewBag(BagAddBindingModel bagAdd);

    void deleteModelById(String id);

    List<BagViewModel> getAllBagsByTypeForOverview(String type);

    BagViewModel getBagDetailsById(String id);

    List<BagViewModel> getAllBagsByFilterCriteria(BagFilterModel filter, String bagType);

    BagModel getBagById(String id);

    boolean editLens(String id, BagEditBindingModel editModel);

}
