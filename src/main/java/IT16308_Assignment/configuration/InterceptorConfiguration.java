//package IT16308_Assignment.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import IT16308_Assignment.interceptors.Interceptor;
//
//@Configuration
//public class InterceptorConfiguration implements WebMvcConfigurer {
//
//	@Autowired
//	private Interceptor interceptor;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(interceptor)
//
//				.addPathPatterns("/admin/**").excludePathPatterns("/admin/login/**")
//				.excludePathPatterns("/admin/getHome/**");
//
//	}
//
//}
