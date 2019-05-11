package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component // 애플리케이션 실행 뒤 뭔가 실행하고 싶을 때 => ApplicationRunner
public class SampleRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    @Value("${junhee.name}")
    private String name;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        logger.info("===================");
        logger.info(name);
        logger.info("===================");
    }
}
