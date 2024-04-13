package ship.project_noa.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SourceDTO {

    private int source_idx;
    private String source_name ;
    private String source_taste;
    private String source_type ;
    private String source_content;
    private String writer;
}
