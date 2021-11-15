package bg.softuni.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class EventListenerTest {

    private static final Logger logger = LoggerFactory.getLogger(AppListenerTest.class);

    @EventListener(ServletRequestHandledEvent.class)
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("I have received an Event: {}", event);
    }

}
