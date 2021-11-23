package softuni.photostore.model.entity.enums;

public enum FlashModesEnum {
    TTL ("TTL"), MANUAL ("Manual");

    private String title;

    FlashModesEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
