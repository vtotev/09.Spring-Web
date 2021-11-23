package softuni.photostore.model.entity.flashes;

import softuni.photostore.model.entity.BaseEntity;
import softuni.photostore.model.entity.cameras.CameraPicture;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class FlashPicture extends BaseEntity {

    private String title;

    private String url;

    private String publicId;

    @ManyToOne
    private FlashModel flash;

    public FlashPicture() {
    }

    public String getTitle() {
        return title;
    }

    public FlashPicture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public FlashPicture setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public FlashPicture setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public FlashModel getFlash() {
        return flash;
    }

    public FlashPicture setFlash(FlashModel flash) {
        this.flash = flash;
        return this;
    }
}
