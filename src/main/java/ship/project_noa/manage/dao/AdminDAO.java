package ship.project_noa.manage.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ship.project_noa.common.dto.PageDTO;
import ship.project_noa.manage.dto.AdminDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdminDAO {
    List<AdminDTO> adminList(PageDTO pageDTO);
    int adminCount(PageDTO pageDTO);
}
