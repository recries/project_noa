package ship.project_noa.manage.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ship.project_noa.common.CommandMap;
import ship.project_noa.common.dto.CategoryDTO;
import ship.project_noa.common.dto.PageDTO;
import ship.project_noa.common.dto.SourceDTO;
import ship.project_noa.common.service.DeleteService;
import ship.project_noa.manage.dto.AdminDTO;
import ship.project_noa.manage.dto.RecipesDTO;
import ship.project_noa.manage.service.RecipesService;

import java.util.List;

@Controller
public class RecipesController {
    @Autowired
    private RecipesService recipesService;
    @Autowired
    private DeleteService deleteService;
    private final ObjectMapper objectMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RecipesController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RequestMapping("/manage/recipes/categoryList")
    public ModelAndView categoryList(CommandMap commandMap, PageDTO pv){
        ModelAndView mv = new ModelAndView("/manage/recipes/categoryList");
        mv.addObject("requestMap", commandMap.getMap());
        List<CategoryDTO> categoryList = recipesService.selectCategoryList(pv);

        mv.addObject("categoryList",categoryList);
        return mv;
    }
    @RequestMapping("/manage/recipes/selectSourceList")
    public ModelAndView selectSourceList(CommandMap commandMap, PageDTO pv){
        ModelAndView mv = new ModelAndView("/manage/recipes/selectSourceList");
        mv.addObject("requestMap", commandMap.getMap());
        List<SourceDTO> selectSourceList = recipesService.selectSourceList(pv);

        mv.addObject("selectSourceList",selectSourceList);
        return mv;
    }

    @PostMapping("/manage/recipes/insertCategory")
    public ResponseEntity<?> insertCategory(@RequestBody RecipesDTO recipesDTO, HttpSession session) {
        int sessionAdminIdx = (Integer) session.getAttribute("session_admin_idx");
        RecipesDTO updatedRecipesDTO = RecipesDTO.builder()
                .session_admin_idx(sessionAdminIdx)
                .category(recipesDTO.getCategory())
                .source(recipesDTO.getSource())
                .build();
        recipesService.insertNewCategory(updatedRecipesDTO);

        // 성공 응답
        return ResponseEntity.ok().body("{}");
    }



    @PostMapping("/manage/recipes/deleteCategory")
    public ResponseEntity<?> deleteCategory(CommandMap commandMap) throws Exception {
        System.out.println(commandMap.getMap());
        deleteService.deleteCategory(commandMap.getMap());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    

}
