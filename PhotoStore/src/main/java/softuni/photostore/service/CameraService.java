package softuni.photostore.service;

import softuni.photostore.model.binding.CameraAddBindingModel;
import softuni.photostore.model.binding.CameraBrandAddBindingModel;
import softuni.photostore.model.entity.cameras.CameraModel;
import softuni.photostore.model.service.CameraFilterModel;

import java.util.List;

public interface CameraService {
    List<CameraModel> getAllCamerasByType(String type);
    List<CameraModel> getAllCameras();

    boolean addNewCamera(CameraAddBindingModel cameraAddBindingModel);

    List<CameraModel> getAllCamerasByFilterCriteria(CameraFilterModel filter, String camType);

    CameraModel getCameraById(String id);

    boolean editCamera(String id, CameraAddBindingModel cameraAddBindingModel);

    void deleteModelById(String id);
}
