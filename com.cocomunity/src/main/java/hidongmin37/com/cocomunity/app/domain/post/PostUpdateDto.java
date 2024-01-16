package hidongmin37.com.cocomunity.app.domain.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostUpdateDto {

    private Long postId;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String contents;

    private LocalDateTime updatedDatetime;

    public PostUpdateDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
        this.updatedDatetime = LocalDateTime.now();
    }
}
