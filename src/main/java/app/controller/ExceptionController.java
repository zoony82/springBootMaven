package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @GetMapping("/exception")
    public String exception(){
        throw new SampleException();
    }

    @ExceptionHandler(SampleException.class) //현재 컨트롤러 안에서 발생하는 SampleException 이라는 예외가 발생하면 나는 이 핸들러를 사용 하겠다.
    public @ResponseBody AppError sampleError(SampleException e){
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK IDK IDK");

        return appError;
    }

}
