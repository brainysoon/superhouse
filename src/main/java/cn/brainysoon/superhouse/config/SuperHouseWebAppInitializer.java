package cn.brainysoon.superhouse.config;

import cn.brainysoon.superhouse.web.WebConfig;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by brainy on 17-2-17.
 */
public class SuperHouseWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //字符集
    public static final String CHARACTER_ENCODING = "UTF-8";

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {

        final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding(CHARACTER_ENCODING);
        encodingFilter.setForceEncoding(true);

        return new Filter[]{encodingFilter};
    }
}
