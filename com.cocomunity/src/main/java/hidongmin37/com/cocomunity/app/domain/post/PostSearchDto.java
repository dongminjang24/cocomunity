package hidongmin37.com.cocomunity.app.domain.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostSearchDto {

    private String keyword;
    private int page;             // 현재 페이지 번호
    private int recordSize;       // 페이지당 출력할 데이터 개수
    private int pageSize;         // 화면 하단에 출력할 페이지 사이즈
    private Pagination pagination;
    public PostSearchDto(String keyword) {
        this.keyword = keyword;
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }

    public int getOffset() {
        return (page - 1) * recordSize;
    }

}
