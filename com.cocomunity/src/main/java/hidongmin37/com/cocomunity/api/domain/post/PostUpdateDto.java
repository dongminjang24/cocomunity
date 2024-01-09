package hidongmin37.com.cocomunity.api.domain.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostUpdateDto {

    private String title;

    private String contents;

    private LocalDateTime updatedDatetime;

    public PostUpdateDto(String title, String contents, LocalDateTime updatedDatetime) {
        this.title = title;
        this.contents = contents;
        this.updatedDatetime = updatedDatetime;
    }
}
