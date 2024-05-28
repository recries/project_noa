package ship.project_noa.common.service;

import jakarta.servlet.http.HttpServletRequest;
import ship.project_noa.manage.dto.AdminDTO;

import java.util.List;
import java.util.Map;


public interface AjaxService {

    boolean idCheck(String admin_id) throws Exception;
    List<Map<String,Object>> uploadFile(Map<String,Object> map, HttpServletRequest request) throws Exception;
}
