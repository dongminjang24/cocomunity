package hidongmin37.com.cocomunity.api.repository.mybatis;

import hidongmin37.com.cocomunity.api.domain.post.Post;
import hidongmin37.com.cocomunity.api.domain.post.PostSearchDto;
import hidongmin37.com.cocomunity.api.domain.post.PostUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MyBatisRepository implements PostMapper{

    private final PostMapper postMapper;


    @Override
    public void save(Post post) {

    }

    @Override
    public void update(Long id, PostUpdateDto postUpdateDto) {

    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Post> findAll(PostSearchDto postSearchDto) {
        return null;
    }
}
