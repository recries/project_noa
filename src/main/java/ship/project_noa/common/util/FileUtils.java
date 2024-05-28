package ship.project_noa.common.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@Component("fileUtils")
public class FileUtils {
    @Value("${security.upload.path.root}")
    private String uploadPathRoot;
    @Value("${security.upload.path.block}")
    private String uploadPathBlock;
    public List<Map<String, Object>> saveUploadFile(HttpServletRequest request, String uploadPathDirectory, String fileNamePattern, String allowExt, boolean downloadBlock) throws Exception{
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
        String filePath = "";
        if(downloadBlock){
            filePath = uploadPathBlock + uploadPathDirectory;
        }else{
            filePath = uploadPathRoot + uploadPathBlock;
        }
        MultipartFile multipartFile = null;
        String originalFileName = null;
        String origianlFileExtension = null;
        String saveFileName = null;
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> listMap = null;

        File file = new File(filePath);
        if(!file.exists()){
            file.mkdir();
        }

        while (iterator.hasNext()){
            multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            if(!multipartFile.isEmpty()){
                originalFileName = multipartFile.getOriginalFilename();
                origianlFileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf(".")).toLowerCase();
                if(allowExt.indexOf(origianlFileExtension) > -1){
                    file = new File(filePath + saveFileName);
                    multipartFile.transferTo(file);

                    listMap = new HashMap<String, Object>();
                    listMap.put("original_file_name", originalFileName);
                    listMap.put("save_file_name", uploadPathDirectory.replace("\\", "/") + saveFileName);
                    list.add(listMap);
                }
            }
        }
        return list;
    }
    public String getReadFile(HttpServletRequest request, String filePath, String fileName) throws Exception{

        String contextRoot =  request.getServletContext().getRealPath("/");
        File path = new File(contextRoot + filePath, fileName);
        String returnContent = "";
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF8"));
            String line;
            while ((line = br.readLine()) != null) {
                returnContent += line;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(br != null) try {br.close(); } catch (IOException e) {}
        }

        return returnContent;
    }

    private String getBrowser(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        if (header.indexOf("MSIE") > -1) {
            return "MSIE";
        } else if (header.indexOf("Chrome") > -1) {
            return "Chrome";
        } else if (header.indexOf("Opera") > -1) {
            return "Opera";
        } else if (header.indexOf("Firefox") > -1) {
            return "Firefox";
        }
        return "MSIE";
        // return "Firefox";
    }

    private String getDisposition(String filename, String browser) throws Exception {
        String dispositionPrefix = "attachment;filename=";
        String encodedFilename = null;
        if (browser.equals("MSIE")) {
            encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
        } else if (browser.equals("Firefox")) {
            encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
        } else if (browser.equals("Opera")) {
            encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
        } else if (browser.equals("Chrome")) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < filename.length(); i++) {
                char c = filename.charAt(i);
                if (c > '~') {
                    sb.append(URLEncoder.encode("" + c, "UTF-8"));
                } else {
                    sb.append(c);
                }
            }
            encodedFilename = sb.toString();
        } else {
            throw new RuntimeException("Not supported browser");
        }
        return dispositionPrefix + encodedFilename;
    }

    public static String makeDirConverter(String str){
        String regex = "[\\\\/:*?\"<>|]";

        str = str.replaceAll(regex, "_");

        return str;
    }
}
