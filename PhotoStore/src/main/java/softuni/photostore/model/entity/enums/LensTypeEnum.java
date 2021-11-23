package softuni.photostore.model.entity.enums;

public enum LensTypeEnum {
    PRIME ("Prime lens"), ZOOM ("ZOOM LENS");

    private String title;

    LensTypeEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
