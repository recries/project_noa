package ship.project_noa.user.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ship.project_noa.common.CommandMap;

@Controller
public class menuController {

    @RequestMapping(value = "/me/recipes")
    public ModelAndView recipes(CommandMap commandMap){
        ModelAndView mv = new ModelAndView("/me/recipes");
        return mv;
    }
}
