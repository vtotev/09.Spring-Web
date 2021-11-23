package softuni.photostore.model.entity.cameras;

import softuni.photostore.model.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CameraPicture extends BaseEntity {

    private String title;

    private String url;

    private String publicId;

    @ManyToOne
    private CameraModel camera;

    public CameraPicture() {
    }

    public String getTitle() {
        return title;
    }

    public CameraPicture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public CameraPicture setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public CameraPicture setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public CameraModel getCamera() {
        return camera;
    }

    public CameraPicture setCamera(CameraModel camera) {
        this.camera = camera;
        return this;
    }
}
