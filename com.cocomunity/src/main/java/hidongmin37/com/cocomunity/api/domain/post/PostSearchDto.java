package hidongmin37.com.cocomunity.api.domain.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostSearchDto {

    private String title;
    private Integer contents;
    private LocalDateTime createdDatetime;

    public PostSearchDto(String title, Integer contents, LocalDateTime createdDatetime) {
        this.title = title;
        this.contents = contents;
        this.createdDatetime = createdDatetime;
    }
}
