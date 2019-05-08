package app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component // 애플리케이션 실행 뒤 뭔가 실행하고 싶을 때 => ApplicationRunner
public class SampleRunner implements ApplicationRunner {

    @Value("${junhee.name}")
    private String name;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        System.out.println("===================");
        System.out.println(name);
        System.out.println("===================");
    }
}
