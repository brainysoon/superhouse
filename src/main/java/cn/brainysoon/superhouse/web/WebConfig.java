package cn.brainysoon.superhouse.web;

import cn.brainysoon.superhouse.dao.StaffRepository;
import cn.brainysoon.superhouse.service.StaffService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by brainy on 17-2-17.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {WebConfig.class, StaffService.class, StaffRepository.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String CSS_LOACTION = "/resources/css/**";
    private static final String JS_LOCATION = "/resources/js/**";
    private static final String IMAGE_LOCATION = "/resources/images/**";
    private static final String FONTS_LOCATION = "/resources/fonts/**";

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler(CSS_LOACTION).addResourceLocations(CSS_LOACTION);
        registry.addResourceHandler(JS_LOCATION).addResourceLocations(JS_LOCATION);
        registry.addResourceHandler(IMAGE_LOCATION).addResourceLocations(IMAGE_LOCATION);
        registry.addResourceHandler(FONTS_LOCATION).addResourceLocations(FONTS_LOCATION);
    }
}
