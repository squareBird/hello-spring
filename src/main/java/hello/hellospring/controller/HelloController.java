package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {

    // 사용자가 접근한 URL을 매칭시켜주는 값
    // ex) localhost:8080/{hello}
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        // templates 폴더에서 아래 hello라고 된 html문서를 찾아서 보여줌줌
       return "hello";
    }
}