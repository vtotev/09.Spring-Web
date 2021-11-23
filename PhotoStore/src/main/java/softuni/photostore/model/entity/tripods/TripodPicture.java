package softuni.photostore.model.entity.tripods;

import softuni.photostore.model.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class TripodPicture extends BaseEntity {

    private String title;

    private String url;

    private String publicId;

    @ManyToOne
    private TripodModel tripod;

    public TripodPicture() {
    }

    public String getTitle() {
        return title;
    }

    public TripodPicture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public TripodPicture setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public TripodPicture setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public TripodModel getTripod() {
        return tripod;
    }

    public TripodPicture setTripod(TripodModel tripod) {
        this.tripod = tripod;
        return this;
    }
}
