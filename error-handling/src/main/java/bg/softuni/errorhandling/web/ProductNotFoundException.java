package bg.softuni.errorhandling.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product not found!")
public class ProductNotFoundException extends RuntimeException {

    private Long productId;

    public ProductNotFoundException(Long productId) {
        super("Product with id " + productId + " was not found!");
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public ProductNotFoundException setProductId(Long productId) {
        this.productId = productId;
        return this;
    }
}
