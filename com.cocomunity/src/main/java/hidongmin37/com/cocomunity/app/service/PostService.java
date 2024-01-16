package hidongmin37.com.cocomunity.app.service;

import hidongmin37.com.cocomunity.app.domain.post.*;

import java.util.List;
import java.util.Optional;

public interface PostService {


    void save(Post post);

    void update(Long postId, PostUpdateDto updateParam);

    Optional<Post> findById(Long id);

    PagingResponse<Post> findAll(PostSearchDto params);

    void delete(Long id);
}
