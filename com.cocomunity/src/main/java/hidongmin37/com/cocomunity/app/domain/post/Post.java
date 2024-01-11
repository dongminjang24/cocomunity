package hidongmin37.com.cocomunity.app.domain.post;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private  Long postId;

    private String title;

    private String contents;

    private int viewCount;

    private int likeCount;

    private LocalDateTime createdDatetime;

    private LocalDateTime updatedDatetime = null;

    @Builder

    public Post(Long postId, String title, String contents, int viewCount, int likeCount, LocalDateTime createdDatetime, LocalDateTime updatedDatetime) {
        this.postId = postId;
        this.title = title;
        this.contents = contents;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.createdDatetime = createdDatetime;
        this.updatedDatetime = updatedDatetime;
    }
}
