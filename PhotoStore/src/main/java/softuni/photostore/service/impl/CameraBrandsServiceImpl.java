package softuni.photostore.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.photostore.model.binding.CameraBrandAddBindingModel;
import softuni.photostore.model.entity.cameras.CameraBrand;
import softuni.photostore.repository.CameraBrandRepository;
import softuni.photostore.service.CameraBrandsService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CameraBrandsServiceImpl implements CameraBrandsService {
    private final CameraBrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public CameraBrandsServiceImpl(CameraBrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CameraBrand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteBrandWithId(String id) {
        brandRepository.deleteById(id);
    }

    @Override
    public CameraBrand getBrandByName(String name) {
        return brandRepository.findByBrandName(name).orElse(null)   ;
    }

    @Override
    public boolean registerNewBrand(CameraBrandAddBindingModel brand) {
        if (isBrandExisting(brand.getBrandName())) {
            return false;
        }
        CameraBrand newBrand = new CameraBrand()
                .setBrandName(brand.getBrandName());
        brandRepository.save(newBrand);
        return true;
    }

    @Override
    public boolean isBrandExisting(String brand) {
        return brandRepository.findByBrandName(brand).isPresent();
    }

}
