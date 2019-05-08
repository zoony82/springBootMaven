package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
        SpringApplication app =  new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.addListeners(new SimpleListner());
        app.run(args);

        // todo : 프로파일 할 차례
    }
}
