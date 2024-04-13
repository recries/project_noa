package ship.project_noa.common.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component("encryptUtils")
public class EncryptUtils {

    public String encSha256(String str) throws Exception {
        String returnSHA = "";

        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        sh.update(str.getBytes());
        byte byteData[] = sh.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        returnSHA = sb.toString();

        return returnSHA;
    }
}