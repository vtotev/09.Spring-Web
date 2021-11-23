package softuni.photostore.model.entity.enums;

public enum LensMountTypeEnum {
    DSLR ("Обективи за DSLR фороапарати", "lenses/dslr"),
    MIRRORLESS ("Обективи за безогледални фотоапарати", "lenses/mirrorless");

    private String title;
    private String href;

    LensMountTypeEnum(String title, String href) {
        this.title = title;
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public String getHref() {
        return href;
    }
}
