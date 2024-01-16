package hidongmin37.com.cocomunity.app.repository.mybatis;

import hidongmin37.com.cocomunity.app.domain.post.Post;
import hidongmin37.com.cocomunity.app.domain.post.PostSearchDto;
import hidongmin37.com.cocomunity.app.domain.post.PostUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {


    List<Post> findAll(PostSearchDto postSearchDto);
    int count(PostSearchDto params);

    void save(Post post);

    void update(@Param("postId") Long postId, @Param("postUpdateDto") PostUpdateDto postUpdateDto);

    Optional<Post> findById(Long id);

    void delete(Long id);

    void updateViewCount(Post post);

}
