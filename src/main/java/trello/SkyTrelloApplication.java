package trello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.context.annotation.Import;

import trello.configure.Thymeleaf3AutoConfiguration;

@Import(Thymeleaf3AutoConfiguration.class)
@SpringBootApplication(exclude = ThymeleafAutoConfiguration.class)
public class SkyTrelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyTrelloApplication.class, args);
		
	}
}
