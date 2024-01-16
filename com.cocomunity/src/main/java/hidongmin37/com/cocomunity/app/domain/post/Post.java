package hidongmin37.com.cocomunity.app.domain.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private  Long postId;

    @NotBlank
    @NotNull
    private String title;

    @NotNull
    private String contents;

    private int viewCount;

    private int likeCount;

    @NotNull
    private LocalDateTime createdDatetime;

    private LocalDateTime updatedDatetime = null;

    public Post() {
    }

    public Post(Long postId, String title, String contents, int viewCount, int likeCount, LocalDateTime createdDatetime, LocalDateTime updatedDatetime) {
        this.postId = postId;
        this.title = title;
        this.contents = contents;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.createdDatetime = createdDatetime;
        this.updatedDatetime = updatedDatetime;
    }
    public Post(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
