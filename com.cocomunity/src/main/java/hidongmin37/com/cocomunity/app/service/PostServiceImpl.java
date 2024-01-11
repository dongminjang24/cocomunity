package hidongmin37.com.cocomunity.app.service;

import hidongmin37.com.cocomunity.app.domain.post.Post;
import hidongmin37.com.cocomunity.app.domain.post.PostSearchDto;
import hidongmin37.com.cocomunity.app.domain.post.PostUpdateDto;
import hidongmin37.com.cocomunity.app.repository.mybatis.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostMapper postMapper;

    @Override
    public void save(Post post) {

        postMapper.save(post);
    }

    @Override
    public void update(Long postId, PostUpdateDto updateParam) {
        postMapper.update(postId,updateParam);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postMapper.findById(id);
    }

    @Override
    public List<Post> findAll(PostSearchDto postSearchDto) {
        List<Post> result = postMapper.findAll(postSearchDto);
        return result;
    }
}
