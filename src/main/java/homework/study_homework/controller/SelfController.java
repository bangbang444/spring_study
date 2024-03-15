package homework.study_homework.controller;

import homework.study_homework.domain.Self;
import homework.study_homework.service.SelfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SelfController {

    private final SelfService selfService;

    public SelfController(SelfService selfService) {
        this.selfService = selfService;
    }

    @GetMapping("self/update")
    public String updateForm(){

        return "/self/updateSelfForm";
    }

    @PostMapping("/self/update")
    public String update(SelfForm form){
        Self self = new Self();
        self.setName(form.getName());
        self.setAge(form.getAge());
        selfService.selfAppend(self);

        return "redirect:/";
    }

    @GetMapping("/self/selfs")
    public String list(Model model){
        List<Self> selfs = selfService.findSelfs();
        model.addAttribute("selfs", selfs);
        return "/self/selfList";
    }

    @GetMapping("/self/self")
    @ResponseBody
    public Self getSelfData() {
        List<Self> selfs = selfService.findSelfs();
        int lastIndex = selfs.size()-1;
        Self lastself = selfs.get(lastIndex);

        return lastself;
    }
}
