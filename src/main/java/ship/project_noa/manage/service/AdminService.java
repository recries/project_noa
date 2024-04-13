package ship.project_noa.manage.service;

import ship.project_noa.common.dto.PageDTO;
import ship.project_noa.manage.dto.AdminDTO;

import java.util.List;
import java.util.Map;

public interface AdminService {
    List<AdminDTO> adminListPaging(PageDTO pageDTO);
}
