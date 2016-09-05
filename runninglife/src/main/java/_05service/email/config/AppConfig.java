package _05service.email.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
@ComponentScan(basePackages = "_05service.email")
@ComponentScan(basePackages = "_05validator")
@EnableWebMvc 
public class AppConfig extends WebMvcConfigurerAdapter{
	
	// Put Other Application configuration here.

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		// Using gmail.
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("mizunarei520@gmail.com");
		mailSender.setPassword("lydia430");

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.debug", "true");

		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}
	/*
	 * FreeMarker configuration.
	 */
	@Bean
	public FreeMarkerConfigurationFactoryBean getFreeMarkerConfiguration() {
		FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("/template/");
		return bean;
	}
//    @Bean
//    public InternalResourceViewResolver getInternalResourceViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/pages/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry
	      .addResourceHandler("/resources/**")
	      .addResourceLocations("/resources/","classpath:/images/","classpath:/","file:/run/")
	      .setCachePeriod(3600)
	      .resourceChain(true)
	      .addResolver(new PathResourceResolver());
	    
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasenames(new String[] { "/validation"});
		return rb;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}
	
}
