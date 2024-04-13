package ship.project_noa.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ship.project_noa.manage.dto.AdminDTO;
import ship.project_noa.common.service.AjaxService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AjaxController {

    @Autowired(required = false)
    private AjaxService aService;

    private AdminDTO adminDTO;

    @RequestMapping(value="/ajax/idCheck", method = {RequestMethod.GET})
    public ResponseEntity<Map<String, Boolean>> idCheck(@RequestParam(value = "admin_id") String admin_id) throws Exception {
        Map<String, Boolean> response = new HashMap<>();

        boolean isIdValid = aService.idCheck(admin_id);
        response.put("useId", isIdValid);

        return ResponseEntity.ok(response);
    }

}
