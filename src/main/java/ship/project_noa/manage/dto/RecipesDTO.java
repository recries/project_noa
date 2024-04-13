package ship.project_noa.manage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ship.project_noa.common.dto.CategoryDTO;
import ship.project_noa.common.dto.SourceDTO;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipesDTO {
    private int session_admin_idx;
    private List<CategoryDTO> category;
    private SourceDTO source;

}
