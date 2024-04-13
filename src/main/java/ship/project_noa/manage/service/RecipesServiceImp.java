package ship.project_noa.manage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ship.project_noa.common.CommandMap;
import ship.project_noa.common.dto.CategoryDTO;
import ship.project_noa.common.dto.PageDTO;
import ship.project_noa.common.dto.SourceDTO;
import ship.project_noa.manage.dao.RecipesDAO;
import ship.project_noa.manage.dto.RecipesDTO;

import java.util.List;
import java.util.Map;

@Service
public class RecipesServiceImp implements RecipesService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RecipesDAO recipesDAO;

    @Override
    public List<CategoryDTO> selectCategoryList(PageDTO pageDTO) {
        return recipesDAO.selectCategoryList(pageDTO);
    }

    @Override
    public List<SourceDTO> selectSourceList(PageDTO pageDTO) {
        return recipesDAO.selectSourceList(pageDTO);
    }

    @Transactional
    @Override
    public void insertNewCategory(RecipesDTO recipesDTO) {
        recipesDAO.insertNewCategory(recipesDTO);
    }

    /*@Transactional
    @Override
    public void deleteCategory(CategoryDTO categoryDTO) {

        recipesDAO.deleteCategory(categoryDTO);
    }*/

    @Override
    public void deleteCategory(Map<String , Object> map) {
        recipesDAO.deleteCategory(map);
    }

    @Transactional
    @Override
    public void insertNewSource(RecipesDTO recipesDTO) {
        recipesDAO.insertNewSource(recipesDTO);
    }
}
