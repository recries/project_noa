package ship.project_noa.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ship.project_noa.common.CommandMap;

@Controller
public class UserController {

    @RequestMapping(value = "/")
    public ModelAndView main(CommandMap commandMap){
        ModelAndView mv = new ModelAndView("main");
        return mv;
    }
}
