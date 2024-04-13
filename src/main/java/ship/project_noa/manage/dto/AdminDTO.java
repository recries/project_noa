package ship.project_noa.manage.dto;

import lombok.*;
import ship.project_noa.common.util.EncryptUtils;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private static final EncryptUtils encryptUtil = new EncryptUtils();
    private int admin_idx;
    private String admin_id;
    private String admin_password;
    private String admin_sha_password;
    private String sha_password;
    private String admin_name;
    private String admin_hp;
    private String admin_email;
    private String admin_nickname;


    public void encryptPrivacy() {
        try {
            admin_sha_password = encryptUtil.encSha256(admin_password);
        }
       catch(Exception e) {
            System.out.println("암호화 오류");
        }
    }
}
