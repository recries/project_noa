package ship.project_noa.login.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ship.project_noa.manage.dto.AdminDTO;

import java.util.List;

public interface LoginService {

    List<AdminDTO> selectAdminList() throws Exception;

    boolean selectLoginAdmin(AdminDTO dto,HttpServletRequest request, HttpSession session) throws Exception;
    void insertAdminInfo(AdminDTO dto) throws Exception;
}