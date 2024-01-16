package hidongmin37.com.cocomunity.app.cotroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hidongmin37.com.cocomunity.app.domain.post.Post;
import hidongmin37.com.cocomunity.app.domain.post.PostSearchDto;
import hidongmin37.com.cocomunity.app.domain.post.PostUpdateDto;
import hidongmin37.com.cocomunity.app.repository.mybatis.PostMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.FlashMap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
class PostControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostMapper postMapper;

    @Test
    @DisplayName("/post/list")
    void postList() throws Exception {

        //given
        Post post = new Post( "제목입니다.", "내용입니다.");
        postMapper.save(post);
        assertNotNull(post.getPostId()); // postId가 자동 생성되었는지 확인

        //
        List<Post> all = postMapper.findAll(new PostSearchDto("제목"));

        Post post1 = all.get(0);
        log.info("{}",post1);
        Assertions.assertThat(post1.getTitle()).isEqualTo("제목입니다.");
    }





    @Test
    @DisplayName("/post/save 요청시에 저장이 된다.")
    void saveTest() throws Exception {
        FlashMap flashMap = mockMvc.perform(MockMvcRequestBuilders.post("/posts/save")
                .param("title", "새로 작성한 글 제목")
                .param("contents", "새로 작성한 글 내용")
        ).andReturn().getFlashMap();
        log.info("FlashMap={}",flashMap);
    }

    @Test
    @DisplayName("/post/update 요청시이 된다.")
    void updateTest() throws Exception {
        Post post = new Post( "제목입니다.", "내용입니다.");
        postMapper.save(post);
        assertNotNull(post.getPostId()); // postId가 자동 생성되었는지 확인
        log.info("{}",post.getPostId());
        postMapper.update(post.getPostId(), new PostUpdateDto("새로운 제목입니다.", "새로운 내용입니다."));
        Optional<Post> newPost = postMapper.findById(post.getPostId());
        log.info("{}",newPost);
        Assertions.assertThat(newPost.get().getContents()).isEqualTo("새로운 내용입니다.");
    }

    @Test
    @DisplayName("/postId/delete 요청시에 삭제된다.")
    void deleteTest() throws Exception {
        Post post = new Post( "제목입니다.", "내용입니다.");
        postMapper.save(post);
        assertNotNull(post.getPostId()); // postId가 자동 생성되었는지 확인
        postMapper.delete(post.getPostId());
        Assertions.assertThat(postMapper.findById(post.getPostId())).isEmpty();
    }




}