package xqy.msa.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages="xqy.msa.springbootweb.**")
//@ImportResource("classpath:app-config.xml")
public class App extends SpringBootServletInitializer
{
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}
}
