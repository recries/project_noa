package ship.project_noa.common.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class PageDTO {

    private int page;             // 현재 페이지 번호
    private int recordSize;       // 페이지당 출력할 데이터 개수
    private int pageSize;         // 화면 하단에 출력할 페이지 사이즈
    private int offset;           // 페이지 limit
    private String keyword;       // 검색 키워드
    private String searchType;    // 검색 유형
    public PageDTO() {
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
        this.offset = getOffset();
    }

    public int getOffset() {
        return (page - 1) * recordSize;
    }

}