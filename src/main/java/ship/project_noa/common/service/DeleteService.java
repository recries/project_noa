package ship.project_noa.common.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ship.project_noa.common.DeleteDAO;

import java.util.Map;

@Service("deleteService")
public class DeleteService {
    @Resource(name="deleteDAO")
    private DeleteDAO deleteDAO;

    public void deleteCategory(Map<String, Object> map) throws Exception {
        deleteDAO.deleteCategory(map);
    }
}
