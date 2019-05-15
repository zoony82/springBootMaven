package app.controller;

import app.user.JacksonUser;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class JacksonController {
    // jackson -> 자동으로 객체에 대한 링크 정보 만들어줌
    @GetMapping("/jackson")
    public Resource<JacksonUser> jackson(){
        JacksonUser ju = new JacksonUser();
        ju.setPrefix("hellooo");
        ju.setName("ju_user_name");

        // Resource : 우리가 제공할 리소스에 링크가 플러스된 정보다
        Resource<JacksonUser> jacksonUserResource = new Resource<>(ju);
        jacksonUserResource.add(linkTo(methodOn(JacksonController.class).jackson()).withSelfRel());

        return jacksonUserResource;

    }
}
