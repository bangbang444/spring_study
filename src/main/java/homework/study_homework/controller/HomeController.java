package homework.study_homework.controller;

import homework.study_homework.service.SelfService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Home";
    } // hi


}
