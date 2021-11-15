package bg.softuni.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppListenerTest implements ApplicationListener {

    private static final Logger logger = LoggerFactory.getLogger(AppListenerTest.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
//        logger.info("I have received an Event: {}", event);
    }
}
