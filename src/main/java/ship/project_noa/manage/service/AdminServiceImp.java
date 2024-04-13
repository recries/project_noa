package ship.project_noa.manage.service;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ship.project_noa.common.dto.PageDTO;
import ship.project_noa.manage.dao.AdminDAO;
import ship.project_noa.manage.dto.AdminDTO;

import java.util.List;

@Log4j2
@Service
public class AdminServiceImp implements AdminService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AdminDAO adminDAO;

    @Override
    public List<AdminDTO> adminListPaging(PageDTO pageDTO) {
        return adminDAO.adminList(pageDTO);
    }
}
