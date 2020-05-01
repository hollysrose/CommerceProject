package com.lec.file;

import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({"com.lec.file"})
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {

	// Bean name must be "multipartResolver", by default Spring uses method name as bean name.
     
	@Bean(name="multipartResolver") 
	public CommonsMultipartResolver getResolver() throws IOException{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		
		//Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSizePerFile(5242880);//5MB
		
		//You may also set other available properties.
		
		return resolver;
	}
	 
	
	/*
	// if the method name is different, you must define the bean name manually like this :
	@Bean(name = "multipartResolver")
    public MultipartResolver createMultipartResolver() {
        return new StandardServletMultipartResolver();
    }
	*/
	
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}