package hidongmin37.com.cocomunity.app.cotroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hidongmin37.com.cocomunity.app.domain.post.Post;
import hidongmin37.com.cocomunity.app.repository.mybatis.PostMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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

import static org.assertj.core.api.Assertions.assertThat;

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
    void listTest() throws Exception {


    }





    @Test
    @DisplayName("/post/save 요청시에 저장이 된다.")
    void saveTest() throws Exception {
        FlashMap flashMap = mockMvc.perform(MockMvcRequestBuilders.post("/posts/save")
                .param("title", "새로 작성한 글 제목")
                .param("contents", "새로 작성한 글 내용")
                .param("viewCount", "0")
                .param("likeCount", "0")
                .param("createdDatetime", String.valueOf(LocalDateTime.now()))
                .param("updatedDatetime", String.valueOf(LocalDateTime.now()))
        ).andReturn().getFlashMap();
        log.info("FlashMap={}",flashMap);

    }

    @Test
    @DisplayName("/post/save 요청시에 저장이 된다.")
    void getTest() throws Exception {
        Post post = new Post(1L, "제목입니다.", "내용입니다.", 0, 0, LocalDateTime.now(), LocalDateTime.now());
        postMapper.save(post);


        //when


        //then
        Post findPost = postMapper.findById(1L).get();
        assertThat(findPost.getPostId()).isEqualTo(post.getPostId());
        assertThat(findPost.getContents()).isEqualTo(post.getContents());
        assertThat(findPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(findPost.getLikeCount()).isEqualTo(post.getLikeCount());
        assertThat(findPost.getViewCount()).isEqualTo(post.getViewCount());
        assertThat(findPost.getCreatedDatetime()).isEqualTo(post.getCreatedDatetime());

    }


}