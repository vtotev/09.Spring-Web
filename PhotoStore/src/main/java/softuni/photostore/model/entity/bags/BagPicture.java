package softuni.photostore.model.entity.bags;

import softuni.photostore.model.entity.BaseEntity;
import softuni.photostore.model.entity.cameras.CameraModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class BagPicture extends BaseEntity {

    private String title;

    private String url;

    private String publicId;

    @ManyToOne
    private BagModel bag;

    public BagPicture() {
    }

    public String getTitle() {
        return title;
    }

    public BagPicture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public BagPicture setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public BagPicture setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public BagModel getBag() {
        return bag;
    }

    public BagPicture setBag(BagModel bag) {
        this.bag = bag;
        return this;
    }
}
