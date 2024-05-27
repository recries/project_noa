package ship.project_noa.common.service;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import ship.project_noa.common.util.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CommonService {
    @Resource(name="fileUtils")
    private FileUtils fileUtils;

    public List<Map<String, Object>> uploadFile(Map<String, Object> map, HttpServletRequest request) throws Exception {
        String uploadPathDirectory = null;
        String fileNamePattern = null;
        String allowExt = null;
        boolean downloadBlock = false;

        //업로드 용도(upload_type)에 맞춰 경로,파일명,가능한 확장자 넣음
        String uploadType = map.get("upload_type").toString();
        SimpleDateFormat formatter = new SimpleDateFormat ( "yyyyMMddHHmmss", Locale.KOREA );
        Date currentTime = new Date();
        String dTime = formatter.format(currentTime);

        switch (uploadType){
            case "category_img":
                uploadPathDirectory = "manage" + File.separator + "logo" + File.separator;
                fileNamePattern = "category_img";
                allowExt = ".jpg.jpeg.png.gif";
                break;
            
        }
        List<Map<String,Object>> list = fileUtils.saveUploadFile(request, uploadPathDirectory, fileNamePattern, allowExt, downloadBlock);
        return list;
    }
}
