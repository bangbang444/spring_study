package homework.study_homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /*
    @GetMapping("/")
    public String home(Model model){
        List<????> selfs = selfService.findSelfs();
        int lastIndex = selfs.size()-1;
        ???? lastself = selfs.get(lastIndex);
        model.addAttribute("self", lastself);

        return "Home";
    }
    */
    @GetMapping("/") // 도메인 첫 번째
    public String home(){
        return "home2"; // home.html
    }

}
