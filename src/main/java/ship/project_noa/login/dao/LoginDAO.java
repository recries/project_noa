package ship.project_noa.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ship.project_noa.manage.dto.AdminDTO;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository

public interface LoginDAO{
    List<AdminDTO> adminList() throws Exception;
    Optional<AdminDTO> selectLoginAdmin(AdminDTO dto);
    void insertAdminInfo(AdminDTO dto);
}


