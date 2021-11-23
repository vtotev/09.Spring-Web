package softuni.photostore.model.entity.lenses;

import softuni.photostore.model.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LensPicture extends BaseEntity {

    private String title;

    private String url;

    private String publicId;

    @ManyToOne
    private LensModel lens;

    public LensPicture() {
    }

    public String getTitle() {
        return title;
    }

    public LensPicture setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public LensPicture setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public LensPicture setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }

    public LensModel getLens() {
        return lens;
    }

    public LensPicture setLens(LensModel lens) {
        this.lens = lens;
        return this;
    }
}
