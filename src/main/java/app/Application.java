package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        SpringApplication app =  new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.addListeners(new SimpleListner());
        app.run(args);

        // todo : 스프링 데이터 3부: MySQL 할차례
    }
}
