package hidongmin37.com.cocomunity.app.cotroller;


import hidongmin37.com.cocomunity.app.domain.post.Post;
import hidongmin37.com.cocomunity.app.domain.post.PostSearchDto;
import hidongmin37.com.cocomunity.app.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts/*")
public class PostController {

    private final PostServiceImpl postService;

    @GetMapping("/list")
    public String findAll(@ModelAttribute("postSearch") PostSearchDto postSearchDto, Model model) {
        List<Post> list = postService.findAll(postSearchDto);
        model.addAttribute("posts", list);
        return "posts/list";
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable long postId,Model model) {
        Post post = postService.findById(postId).get();
        log.info("{}",post);
        model.addAttribute("post", post);
        return "posts/detail";
    }


    @GetMapping("/save")
    public String saveForm() {
        return "posts/addForm";
    }

    @PostMapping("/save")
    public RedirectView save(Post post, RedirectAttributes redirectAttributes) {
        postService.save(post);
        Long postId = post.getPostId();
        redirectAttributes.addFlashAttribute("postId",postId);//플래시 방식
        return new RedirectView("/posts/list");
    }



}
