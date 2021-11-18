package bg.softuni.events;

import bg.softuni.events.orderListeners.OrderCreateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductQuantityCalculator {

    private static final Logger logger = LoggerFactory.getLogger(ProductQuantityCalculator.class);

    @EventListener(OrderCreateEvent.class)
    public void onOrderCreated(OrderCreateEvent orderCreateEvent) {
        logger.info("Order no. {} has been created. I'm going to give bonus points to the client.", orderCreateEvent.getOrderId());

        // Todo - give bonus points to client

    }


}
