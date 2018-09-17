package utp.alumno.app.configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import utp.alumno.app.constant.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;


@Configuration
public class ThymeleafWebMvcConfig implements WebMvcConfigurer{
	
	@Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Bean
    public ITemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        //templateEngine.addTemplateResolver(templateResolver());
        templateEngine.setMessageSource(messageSource());
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

    private ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding(utils.CHARACTER_ENCODING);
        templateResolver.setCacheable(false);
        return templateResolver;
    }
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
        msgSource.setAlwaysUseMessageFormat(false);
        msgSource.setBasename("messages");
        msgSource.setDefaultEncoding(utils.CHARACTER_ENCODING);
        msgSource.setFallbackToSystemLocale(true);
        msgSource.setUseCodeAsDefaultMessage(false);
        return msgSource;
    }
    
	/*
	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	//CONFIGURACION DE ARCHIVOS
	
	//1. Creating SpringResourceTemplateResolver
    @Bean
    public SpringResourceTemplateResolver springHtmlTemplateResolver(){
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(this.applicationContext);
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding(utils.CHARACTER_ENCODING);
        return resolver;
    }
    
    @Bean
    public SpringResourceTemplateResolver springJavaScriptTemplateResolver(){
    	SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setOrder(1);
        resolver.setCheckExistence(true);
        resolver.setPrefix("classpath:/static/js/");
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.JAVASCRIPT);
        resolver.setCharacterEncoding(utils.CHARACTER_ENCODING);
        return resolver;
    }
    
    //2. Creating SpringTemplateEngine
    @Bean
    public SpringTemplateEngine springTemplateEngine(){
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        //springTemplateEngine.setTemplateResolver(springTemplateResolver());
        springTemplateEngine.setMessageSource(messageSource());
        springTemplateEngine.addTemplateResolver(springHtmlTemplateResolver());
        springTemplateEngine.addTemplateResolver(springJavaScriptTemplateResolver());
        return springTemplateEngine;
    }

    //3. Registering ThymeleafViewResolver 
    @Bean
    public ViewResolver htmlViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(springTemplateEngine());
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding(utils.CHARACTER_ENCODING);
        resolver.setViewNames(new String[] { "*.html" });
        return resolver;
    }

    @Bean
    public ViewResolver javascriptViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(springTemplateEngine());
        resolver.setContentType("application/javascript");
        //resolver.setCharacterEncoding(utils.CHARACTER_ENCODING);
        resolver.setViewNames(new String[] { "*.js" });
        return resolver;
    }

    //4. Others
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource msgSource = new ResourceBundleMessageSource();
        msgSource.setAlwaysUseMessageFormat(false);
        msgSource.setBasename("messages");
        msgSource.setDefaultEncoding(utils.CHARACTER_ENCODING);
        msgSource.setFallbackToSystemLocale(true);
        msgSource.setUseCodeAsDefaultMessage(false);
        return msgSource;
    }
    */
    
}
