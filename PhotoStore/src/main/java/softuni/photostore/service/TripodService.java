package softuni.photostore.service;

import softuni.photostore.model.binding.TripodAddBindingModel;
import softuni.photostore.model.binding.TripodBrandAddBindingModel;
import softuni.photostore.model.binding.TripodEditBindingModel;
import softuni.photostore.model.entity.tripods.TripodBrand;
import softuni.photostore.model.entity.tripods.TripodModel;
import softuni.photostore.model.view.TripodManageViewModel;
import softuni.photostore.model.view.TripodViewModel;

import java.util.List;

public interface TripodService {


    // BRAND METHODS

    List<TripodBrand> getAllBrands();

    boolean isBrandExisting(String brandName);

    boolean registerNewBrand(TripodBrandAddBindingModel brand);

    void deleteBrandWithId(String id);

    TripodBrand getBrandByName(String brand);

    // MODEL METHODS

    List<TripodViewModel> getAllTripodsOverviewModel();

    List<TripodManageViewModel> getAllTripodsForManagement();

    boolean addNewTripod(TripodAddBindingModel tripodAdd);

    void deleteModelById(String id);

    TripodModel getTripodById(String id);

    boolean editTripod(String id, TripodEditBindingModel editModel);

//    BagViewModel getBagDetailsById(String id);
//
//    List<BagViewModel> getAllBagsByFilterCriteria(BagFilterModel filter, String bagType);
//
//    boolean editLens(String id, BagEditBindingModel editModel);
//
}
