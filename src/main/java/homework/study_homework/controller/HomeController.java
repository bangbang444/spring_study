package homework.study_homework.controller;

import homework.study_homework.domain.Self;
import homework.study_homework.service.SelfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final SelfService selfService;

    public HomeController(SelfService selfService) {
        this.selfService = selfService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<Self> selfs = selfService.findSelfs();
        int lastIndex = selfs.size()-1;
        Self lastself = selfs.get(lastIndex);
        model.addAttribute("self", lastself);

        return "Home";
    }


}
