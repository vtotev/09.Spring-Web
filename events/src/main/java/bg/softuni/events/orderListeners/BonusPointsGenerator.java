package bg.softuni.events.orderListeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BonusPointsGenerator {

    private static final Logger logger = LoggerFactory.getLogger(OrderCreateEvent.class);

    @EventListener(OrderCreateEvent.class)
    public void onOrderCreated(OrderCreateEvent orderCreateEvent) {
        logger.info("Order no. {} has been created. I'm going to calculate the current quantity..", orderCreateEvent.getOrderId());

        // Todo - products have been ordered and calculate subtract product quantity.

    }


}
