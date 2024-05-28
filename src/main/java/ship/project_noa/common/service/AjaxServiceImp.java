package ship.project_noa.common.service;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ship.project_noa.common.dao.AjaxDAO;
import ship.project_noa.common.util.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class AjaxServiceImp implements AjaxService {
    @Resource(name="fileUtils")
    private FileUtils fileUtils;
    @Autowired
    private AjaxDAO ajaxDAO;
    @Override
    public boolean idCheck(String admin_id) throws Exception {
        return ajaxDAO.idCheck(admin_id) == 0;
    }

    @Override
    public List<Map<String, Object>> uploadFile(Map<String, Object> map, HttpServletRequest request) throws Exception {
        String uploadPathDirectory = null;
        String fileNamePattern = null;
        String allowExt = null;
        boolean downloadBlock = false;

        //업로드 용도(upload_type)에 맞춰 경로,파일명,가능한 확장자 넣음
        String uploadType = map.get("upload_type").toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
        Date currentTime = new Date();
        String dTime = formatter.format(currentTime);

        switch (uploadType) {
            case "photo":
                uploadPathDirectory = "photo" + File.separator;
                fileNamePattern = dTime;
                allowExt = ".jpg.jpeg.png.gif";
                break;
           /* case "attach":
                uploadPathDirectory = "apply" + File.separator + map.get("comp_idx").toString() + File.separator + map.get("recruit_idx").toString() + File.separator + "attach" + File.separator;
                fileNamePattern = map.get("comp_idx").toString() + "_" + map.get("upload_num").toString();
                allowExt = ".jpg.jpeg.png.gif.doc.docx.xls.xlsx.ppt.pptx.hwp.pdf.zip";
                break;
           */
        }
        List<Map<String,Object>> list = fileUtils.saveUploadFile(request, uploadPathDirectory, fileNamePattern, allowExt, downloadBlock);
        return list;
    }
}
