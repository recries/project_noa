package ship.project_noa.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ship.project_noa.common.dao.AjaxDAO;

@Service
public class AjaxServiceImp implements AjaxService {

    @Autowired
    private AjaxDAO ajaxDAO;
    @Override
    public boolean idCheck(String admin_id) throws Exception {
        return ajaxDAO.idCheck(admin_id) == 0;
    }

}
