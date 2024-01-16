package hidongmin37.com.cocomunity.app.domain.post;

import hidongmin37.com.cocomunity.app.repository.mybatis.PostMapper;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class PagingResponse<T> {

    private List<T> list = new ArrayList<>();
    private Pagination pagination;


    public PagingResponse(List<T> list, Pagination pagination) {
        this.list.addAll(list);
        this.pagination = pagination;
    }


}
