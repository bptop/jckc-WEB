package cn.bptop.jckc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
//        registry.addViewController("/").setViewName("");
////        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/login.html").setViewName("login");
//        registry.addViewController("/home.html").setViewName("index");
    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry)
//    {
//        registry .addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/user/login","/login.html");
//
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/file/**").addResourceLocations("file:C:/file/");
    }
}
