package hidongmin37.com.cocomunity.api.domain.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private Long id;

    private String title;

    private String contents;

    private Integer quantity;

    private int viewCount;

    private int likeCount;

    private LocalDateTime createdDatetime;

    private LocalDateTime updatedDatetime;

    public Post(String title, String contents, Integer quantity, int viewCount, int likeCount, LocalDateTime createdDatetime, LocalDateTime updatedDatetime) {
        this.title = title;
        this.contents = contents;
        this.quantity = quantity;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.createdDatetime = createdDatetime;
        this.updatedDatetime = null;
    }
}
