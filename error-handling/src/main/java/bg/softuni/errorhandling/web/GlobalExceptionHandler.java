package bg.softuni.errorhandling.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({ProductNotFoundException.class})
    public ModelAndView handleDbExceptions(ProductNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView("object-not-found");
        modelAndView.addObject("objectId", e.getProductId());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }

}
