package ship.project_noa.common.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ship.project_noa.manage.dto.AdminDTO;

@Repository
@Mapper
public interface AjaxDAO {
    int idCheck (String admin_id) throws Exception;

}

