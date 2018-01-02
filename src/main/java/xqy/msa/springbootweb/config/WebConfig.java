package xqy.msa.springbootweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(!registry.hasMappingForPattern("/resources/static/**")) {
            registry
                    .addResourceHandler("/resources/static/**")
                    .addResourceLocations("classpath:/static/");
        }
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        super.configurePathMatch(configurer);
//
//        configurer.setUseSuffixPatternMatch(false);
//    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addRedirectViewController("/admin","/admin/index.html");
//        super.addViewControllers(registry);
//    }
}
