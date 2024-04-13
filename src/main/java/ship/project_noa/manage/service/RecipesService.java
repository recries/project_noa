package ship.project_noa.manage.service;

import ship.project_noa.common.CommandMap;
import ship.project_noa.common.dto.CategoryDTO;
import ship.project_noa.common.dto.PageDTO;
import ship.project_noa.common.dto.SourceDTO;
import ship.project_noa.manage.dto.RecipesDTO;

import java.util.List;
import java.util.Map;

public interface RecipesService {
    List<CategoryDTO> selectCategoryList(PageDTO pageDTO);
    List<SourceDTO> selectSourceList(PageDTO pageDTO);
    void insertNewCategory(RecipesDTO recipesDTO);
    void insertNewSource(RecipesDTO recipesDTO);

    //void deleteCategory(CategoryDTO categoryDTO);
    void deleteCategory(Map<String, Object> map);
}
