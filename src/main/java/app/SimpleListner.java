package app;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component // bean으로 등록, 하지만 어플리케이션 컨텍스트 생성이 되지 않은 시점이라 listener에 별도 등록 필요
public class SimpleListner implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent){
        System.out.println("======================================");
        System.out.println("ApplicationStartingEvent jun");
        System.out.println("======================================");
    }
}
