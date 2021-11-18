package bg.softuni.events;

import bg.softuni.events.orderListeners.OrderCreateEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TestController {

    private final ApplicationEventPublisher appEventPublisher;

    public TestController(ApplicationEventPublisher appEventPublisher) {
        this.appEventPublisher = appEventPublisher;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/create-order")
    public String createOrder() {
        ApplicationEvent event = new OrderCreateEvent(this, UUID.randomUUID().toString());
        appEventPublisher.publishEvent(event);
        return "create-order-test";
    }

}
