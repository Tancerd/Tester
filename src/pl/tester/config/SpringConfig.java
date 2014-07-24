package pl.tester.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"pl.tester"})
public class SpringConfig extends WebMvcConfigurerAdapter {

		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
		}

		@Bean
		public FreeMarkerViewResolver getFreeMarkerViewResolver() {
			FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
			resolver.setPrefix("");
			resolver.setSuffix(".htm");
			resolver.setCache(true);
			return resolver;
		}

		@Bean
		public FreeMarkerConfigurer getFreeMarkerConfigurer() {
			FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
			configurer.setTemplateLoaderPath("/WEB-INF/pages/");
			Properties properties = new Properties();
			properties.setProperty("default_encoding", "UTF-8");
			configurer.setFreemarkerSettings(properties);
			return configurer;
		}
}
