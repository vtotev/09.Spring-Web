package bg.softuni.errorhandling.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Object not found!")
public class ObjectNotFoundException extends RuntimeException {

    private Long productId;

    public ObjectNotFoundException(Long productId) {
        super("Object with id " + productId + " was not found!");
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

}
