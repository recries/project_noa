package ship.project_noa.manage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ship.project_noa.common.CommandMap;
import ship.project_noa.common.dto.PageDTO;
import ship.project_noa.manage.dto.AdminDTO;
import ship.project_noa.manage.service.AdminService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ContentController {

    @Autowired
    private AdminService adminService;
    private final ObjectMapper objectMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private AdminDTO adminDTO;

    public ContentController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RequestMapping("/manage/content/main")
    public ModelAndView manageMain(PageDTO pv, CommandMap commandMap) throws JsonProcessingException {
        ModelAndView mv = new ModelAndView("/manage/content/main");
        mv.addObject("requestMap", commandMap.getMap());
        List<AdminDTO> adminList = adminService.adminListPaging(pv);

        mv.addObject("adminList",adminList);

        return mv;
    }
}