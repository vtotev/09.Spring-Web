package softuni.photostore.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.photostore.model.binding.CameraAddBindingModel;
import softuni.photostore.model.entity.PictureEntity;
import softuni.photostore.model.entity.cameras.CameraModel;
import softuni.photostore.model.entity.enums.CameraSensorSizeEnum;
import softuni.photostore.model.entity.enums.CameraTypeEnum;
import softuni.photostore.model.service.CameraFilterModel;
import softuni.photostore.repository.CameraModelRepository;
import softuni.photostore.service.CameraBrandsService;
import softuni.photostore.service.CameraService;
import softuni.photostore.service.PictureService;

import java.io.IOException;
import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {

    private final CameraModelRepository cameraRepository;
    private final CameraBrandsService brandsService;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;

    public CameraServiceImpl(CameraModelRepository cameraRepository, CameraBrandsService brandsService, PictureService pictureService, ModelMapper modelMapper) {
        this.cameraRepository = cameraRepository;
        this.brandsService = brandsService;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CameraModel> getAllCamerasByType(String type) {
        return cameraRepository.findAllByCameraType(CameraTypeEnum.valueOf(type.toUpperCase()));
    }

    @Override
    public List<CameraModel> getAllCameras() {
        return cameraRepository.findAll();
    }

    @Override
    public boolean addNewCamera(CameraAddBindingModel cameraAddBindingModel) {
        PictureEntity picture = null;
        picture = pictureService.addPicture(cameraAddBindingModel.getCameraName(), cameraAddBindingModel.getPicture());

//            CloudinaryImage pictureUpload;
//            try {
//                pictureUpload = cloudinaryService.upload(cameraAddBindingModel.getPicture());
//            } catch (IOException e) {
//                return false;
//            }
//            picture = new PictureEntity();
//            picture.setTitle(cameraAddBindingModel.getCameraName())
//                    .setPublicId(pictureUpload.getPublicId())
//                    .setUrl(pictureUpload.getUrl());
//            picture = pictureService.addPicture(picture);
//        }
        CameraModel camera = modelMapper.map(cameraAddBindingModel, CameraModel.class);
        camera.setBrand(brandsService.getBrandByName(cameraAddBindingModel.getBrand()))
                .setPictures(picture);

        cameraRepository.save(camera);
        return true;
    }

    @Override
    public List<CameraModel> getAllCamerasByFilterCriteria(CameraFilterModel filter, String camType) {
        return cameraRepository.findAllByFilterCriteria(
                camType,
                (filter.getBrand() != null && filter.getBrand() != "") ? filter.getBrand() : null,
                (filter.getSensorSize() != "" && filter.getSensorSize() != null) ? CameraSensorSizeEnum.valueOf(filter.getSensorSize().toUpperCase()).name() : null,
                filter.getPriceFrom() != null ? filter.getPriceFrom() : null,
                filter.getPriceTo() != null ? filter.getPriceTo() : null);
    }

    @Override
    public CameraModel getCameraById(String id) {
        return cameraRepository.findById(id).orElse(null);
    }

    @Override
    public boolean editCamera(String id, CameraAddBindingModel editModel) {
        CameraModel camToEdit = cameraRepository.findById(id).orElse(null);
        PictureEntity picture = camToEdit.getPictures();
        String oldPictureId = picture.getPublicId();
//        if (!editModel.getPicture().isEmpty()) {
//            CloudinaryImage pictureUpload;
//            try {
//                pictureUpload = cloudinaryService.upload(editModel.getPicture());
//            } catch (IOException e) {
//                return false;
//            }
//            picture.setTitle(editModel.getCameraName())
//                    .setPublicId(pictureUpload.getPublicId())
//                    .setUrl(pictureUpload.getUrl());
//            pictureService.deletePicture(picture);
//            picture = pictureService.addPicture(picture);
//            cloudinaryService.delete(oldPictureId);
//        }
        camToEdit = modelMapper.map(editModel, CameraModel.class);
        camToEdit.setBrand(brandsService.getBrandByName(editModel.getBrand()))
                .setPictures(picture);
//        camToEdit.setBrand(brandsService.getBrandByName(editModel.getBrand()))
//                .setCameraName(editModel.getCameraName())
//                .setCameraType(editModel.getCameraType())
//                .setDescription(editModel.getDescription())
//                .setMegapixels(editModel.getMegapixels())
//                .setSensorSize(editModel.getSensorSize())
//                .setQuantity(editModel.getQuantity())
//                .setPictures(picture);

        cameraRepository.save(camToEdit);
        return true;
    }

    @Override
    public void deleteModelById(String id) {
        CameraModel toDelete = cameraRepository.findById(id).orElse(null);
        pictureService.deletePicture(toDelete.getPictures());
        cameraRepository.delete(toDelete);
    }
}
