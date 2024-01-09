package hidongmin37.com.cocomunity.api.repository.mybatis;

import hidongmin37.com.cocomunity.api.domain.post.Post;
import hidongmin37.com.cocomunity.api.domain.post.PostSearchDto;
import hidongmin37.com.cocomunity.api.domain.post.PostUpdateDto;
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
