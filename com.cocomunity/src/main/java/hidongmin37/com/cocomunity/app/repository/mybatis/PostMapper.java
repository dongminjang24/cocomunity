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

    void save(Post post);

    void update(@Param("id") Long id, @Param("updateParam") PostUpdateDto postUpdateDto);

    Optional<Post> findById(Long id);

    List<Post> findAll(PostSearchDto postSearchDto);

}
