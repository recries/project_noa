package ship.project_noa.login.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ship.project_noa.common.CommandMap;
import ship.project_noa.manage.dto.AdminDTO;
import ship.project_noa.login.service.LoginService;
import ship.project_noa.manage.dto.RecipesDTO;

@Controller

public class LoginController {

    @Autowired
    private LoginService loginService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ObjectMapper objectMapper;
    private AdminDTO adminDTO;

    public LoginController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RequestMapping(value = "/caresite")
    public ModelAndView caresite() throws Exception {
        ModelAndView mv = new ModelAndView("/login/login");

        return mv;
    }

    @RequestMapping(value = "/login/createUser")
        public ModelAndView creatUser() throws Exception {

            ModelAndView mv = new ModelAndView("/login/createUser");
            //mv.addObject("adminList", loginService.selectAdminList());
        return mv;
    }
    @RequestMapping("/login/insertAdminInfo")
    public ModelAndView insertAdminInfo(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("/common/hiddenFrame");
        String json = objectMapper.writeValueAsString(commandMap.getMap());

        // JSON 문자열을 AdminDTO 객체로 변환
        AdminDTO adminDTO = objectMapper.readValue(json, AdminDTO.class);
        loginService.insertAdminInfo(adminDTO);
        mv.addObject("alertMsg","저장되었습니다.");
        mv.addObject("goPostUrl","/caresite");

        return mv;
    }
    @PostMapping("/login/loginAuth")
    public ModelAndView loginAuth(HttpServletRequest request, @RequestBody AdminDTO adminDTO, HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/common/hiddenFrame");
        boolean blLoginAuth = loginService.selectLoginAdmin(adminDTO, request, session);

        if(blLoginAuth){
            mv.addObject("alertMsg","저장되었습니다.");
            mv.addObject("goPostUrl","/manage/content/main");
        }else {
            mv.addObject("alertMsg","로그인 할 수 없습니다.");
            mv.addObject("goPostUrl","/caresite");
        }
        return mv;
    }
    @RequestMapping("/login/logout")
    public String  adminLogout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/caresite";
    }

    @RequestMapping("/login/findLoginInfo")
    public ModelAndView findLoginInfo(CommandMap commandMap){
        ModelAndView mv = new ModelAndView("/login/findLoginInfo");

        return mv;
    }
}
