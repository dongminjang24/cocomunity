package hidongmin37.com.cocomunity.app.service;

import hidongmin37.com.cocomunity.app.domain.post.Post;
import hidongmin37.com.cocomunity.app.domain.post.PostSearchDto;
import hidongmin37.com.cocomunity.app.domain.post.PostUpdateDto;

import java.util.List;
import java.util.Optional;

public interface PostService {


    void save(Post post);

    void update(Long postId, PostUpdateDto updateParam);

    Optional<Post> findById(Long id);

    List<Post> findAll(PostSearchDto postSearchDto);
}
