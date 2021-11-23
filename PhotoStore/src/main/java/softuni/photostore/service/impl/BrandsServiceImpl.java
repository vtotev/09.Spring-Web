package softuni.photostore.service.impl;

import org.springframework.stereotype.Service;
import softuni.photostore.model.entity.cameras.CameraBrand;
import softuni.photostore.repository.BrandRepository;
import softuni.photostore.service.BrandsService;

import java.util.List;

@Service
public class BrandsServiceImpl implements BrandsService {
    private final BrandRepository brandRepository;

    public BrandsServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<CameraBrand> getAllBrands() {
        return brandRepository.findAll();
    }
}
