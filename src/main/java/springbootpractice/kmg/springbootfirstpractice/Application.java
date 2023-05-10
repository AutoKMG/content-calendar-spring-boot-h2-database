package springbootpractice.kmg.springbootfirstpractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springbootpractice.kmg.springbootfirstpractice.model.Content;
import springbootpractice.kmg.springbootfirstpractice.model.Status;
import springbootpractice.kmg.springbootfirstpractice.model.Type;
import springbootpractice.kmg.springbootfirstpractice.repository.ContentRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository){
		return args -> {
			Content content  = new Content(
					null,
					"you are watching Khaled practicing Spring boot",
					"Hope you learn something new",
					Status.IDEA,
					Type.COURSE,
					LocalDateTime.now(),
					null,
					"");
			repository.save(content);
		};
	}
}
