package app.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/hellouser")
    public @ResponseBody String hellouser(){ //
        return "hello user return";
    }


    // 기본적으로 json 메세지 컨버터가 사용되어서, 객체가 변환되서 응답된다
    // 또는 @ResponseBody Int, String 가능 하다
    // 해당 클래스에 @RestController 가 붙어 있으면 @ResponseBody 를 생략해도 됨
    @PostMapping("/users/create")
    public @ResponseBody User create(@RequestBody User user){
        return user;
    }
}
