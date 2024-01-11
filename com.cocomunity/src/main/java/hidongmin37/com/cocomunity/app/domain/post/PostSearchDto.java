package hidongmin37.com.cocomunity.app.domain.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostSearchDto {

    private String titleOrContents;

    public PostSearchDto(String titleOrContents) {
        this.titleOrContents = titleOrContents;
    }
}
