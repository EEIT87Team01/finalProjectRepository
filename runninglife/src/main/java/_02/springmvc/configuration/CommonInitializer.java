package _02.springmvc.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;

public class CommonInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//OpenSessionInViewFilter  
        OpenSessionInViewFilter hibernateSessionInViewFilter = new OpenSessionInViewFilter();  
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(  
                "hibernateFilter", hibernateSessionInViewFilter);  
        filterRegistration.addMappingForUrlPatterns(  
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/");  

	}

}
