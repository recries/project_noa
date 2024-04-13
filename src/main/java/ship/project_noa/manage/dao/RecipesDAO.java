package ship.project_noa.manage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ship.project_noa.common.CommandMap;
import ship.project_noa.common.dto.CategoryDTO;
import ship.project_noa.common.dto.PageDTO;
import ship.project_noa.common.dto.SourceDTO;
import ship.project_noa.manage.dto.RecipesDTO;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface RecipesDAO {

    List<CategoryDTO> selectCategoryList(PageDTO pageDTO);
    void insertNewCategory (RecipesDTO recipesDTO);
    //void deleteCategory(CategoryDTO categoryDTO);
    void deleteCategory(Map<String, Object> map);
    List<SourceDTO> selectSourceList(PageDTO pageDTO);
    void insertNewSource (RecipesDTO recipesDTO);
}
