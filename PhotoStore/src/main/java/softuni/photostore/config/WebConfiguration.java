package softuni.photostore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import softuni.photostore.web.interceptor.StatsInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  private final StatsInterceptor statsInterceptor;

  public WebConfiguration(StatsInterceptor statsInterceptor) {
    this.statsInterceptor = statsInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(statsInterceptor);
  }
}
