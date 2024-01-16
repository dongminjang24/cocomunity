package hidongmin37.com.cocomunity.app.service;

import hidongmin37.com.cocomunity.app.domain.post.*;
import hidongmin37.com.cocomunity.app.repository.mybatis.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostMapper postMapper;

    @Override
    public PagingResponse<Post> findAll(PostSearchDto params) {
        int count = postMapper.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<Post> list = postMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }



    @Override
    public void save(Post post) {
        postMapper.save(post);
    }

    @Override
    public void update(Long postId, PostUpdateDto postUpdateDto) {
        postMapper.update(postId,postUpdateDto);
    }

    @Override
    public Optional<Post> findById(Long id) {
        Optional<Post> byId = postMapper.findById(id);
        if (byId.isPresent()) {
            log.info("{}!!!!", byId.isPresent());
            Post post = byId.get();
            int likeCount = post.getViewCount();
            post.setViewCount(likeCount + 1);
            postMapper.updateViewCount(post); // 조회수 업데이트
            return byId;
        }else {
            throw new IllegalStateException("post not found");
        }
    }



    @Override
    public void delete(Long id) {
        postMapper.delete(id);
    }
}
