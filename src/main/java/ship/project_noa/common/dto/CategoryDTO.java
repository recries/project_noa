package ship.project_noa.common.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int category_idx;
    private String category_name;
    private String category_content;
    private int writer;
    private String w_date;
}
