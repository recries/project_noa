package ship.project_noa.common.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ship.project_noa.common.CommandMap;
import ship.project_noa.common.service.CommonService;

import java.util.List;
import java.util.Map;

@Controller
public class CommonController {

    @Resource(name="commonService")
    private CommonService commonService;

    @Value("${security.upload.path.virtual}")
    private String uploadPathVirtual;
    @RequestMapping(value="/common/uploadFile")
    public ModelAndView uploadFile(CommandMap commandMap, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("jsonView");

        List<Map<String,Object>> list = commonService.uploadFile(commandMap.getMap(), request);
        mv.addObject("list", list);

        return mv;
    }
}
