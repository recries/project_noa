package ship.project_noa.login.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import ship.project_noa.common.util.EncryptUtils;
import ship.project_noa.login.dao.LoginDAO;
import ship.project_noa.manage.dto.AdminDTO;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LoginServiceImp implements LoginService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private EncryptUtils encryptUtils;

    @Override
    public List<AdminDTO> selectAdminList() throws Exception {
        return loginDAO.adminList();
    }
    @Transactional
    @Override
    public boolean selectLoginAdmin(AdminDTO dto, HttpServletRequest request, HttpSession session) throws Exception {
        dto.encryptPrivacy();
        System.out.println(loginDAO.selectLoginAdmin(dto));
        try {
            Optional<AdminDTO> result = loginDAO.selectLoginAdmin(dto);

            if (result.isPresent()) {
                AdminDTO admin = result.get();
                session.setAttribute("session_admin_idx", admin.getAdmin_idx());
                session.setAttribute("session_admin_name", admin.getAdmin_name());
                session.setMaxInactiveInterval(60*120);
                return true;
            } else {
                System.out.println("admin_idx = 없음");
                return false;
            }
        } catch (Exception e) {
            System.out.println("로그인 오류: " + e.getMessage());
            throw e;
        }
    }
    @Transactional
    @Override
    public void insertAdminInfo(AdminDTO dto) {
            dto.encryptPrivacy();
            loginDAO.insertAdminInfo(dto);
    }
    
}
