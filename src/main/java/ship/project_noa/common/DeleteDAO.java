package ship.project_noa.common;

import org.springframework.stereotype.Repository;
import ship.project_noa.common.dao.AbstractDAO;

import java.util.Map;

@Repository("deleteDAO")
public class DeleteDAO extends AbstractDAO {
    public void deleteCategory(Map<String, Object> map) throws Exception{
        delete("deleteSpace.deleteCategory", map);
    }

}
