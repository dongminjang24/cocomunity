package hidongmin37.com.cocomunity.app.cotroller;


import hidongmin37.com.cocomunity.app.domain.post.PagingResponse;
import hidongmin37.com.cocomunity.app.domain.post.Post;
import hidongmin37.com.cocomunity.app.domain.post.PostSearchDto;
import hidongmin37.com.cocomunity.app.domain.post.PostUpdateDto;
import hidongmin37.com.cocomunity.app.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts/*")
public class PostController {

    private final PostServiceImpl postService;

    @GetMapping("/list")
    public String findAll(@ModelAttribute("postSearch") PostSearchDto params, Model model) {
        PagingResponse<Post> paging = postService.findAll(params);
        List<Post> list = paging.getList();
        model.addAttribute("posts", list);
        model.addAttribute("paging", paging.getPagination());
        return "posts/list";
    }


    @GetMapping("/{postId}")
    public String getPost(@PathVariable long postId, Model model) {
        Post post = postService.findById(postId).get();
        log.info("{}", post);
        model.addAttribute("post", post);
        return "posts/detail";
    }


    @GetMapping("/save")
    public String saveForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/addForm";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute Post post, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (post.getTitle() == null || post.getTitle().isBlank()) {
            bindingResult.addError(new FieldError("post", "title", "공백은 허용하지 않습니다."));
        }

        if (post.getContents() == null || post.getContents().isBlank() || post.getContents().length() < 5) {
            bindingResult.addError(new FieldError("post", "contents", "5글자 이상 입력하세요."));
        }


        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "posts/addForm";
        }


        postService.save(post); // postService는 'postId'를 반환해야 함
        Long postId = post.getPostId();
        redirectAttributes.addFlashAttribute("postId", postId);
        return "redirect:/posts/" + postId; // 상세 페이지로 리다이렉트
    }

    @GetMapping("/{postId}/edit")
    public String updatePost(@PathVariable Long postId, Model model) {
        Post post = postService.findById(postId).get();
        log.info("{}", post);
        model.addAttribute("post", post);
        return "posts/editForm";
    }

    @PostMapping("/{postId}/edit")
    public String update(@PathVariable Long postId,
                         @ModelAttribute("post") PostUpdateDto postUpdateDto,
                         BindingResult bindingResult,
                         Model model) {

        if (postUpdateDto.getTitle() == null || postUpdateDto.getTitle().isBlank()) {
            bindingResult.addError(new FieldError("post", "title", "공백은 허용하지 않습니다."));
        }

        if (postUpdateDto.getContents() == null || postUpdateDto.getContents().isBlank() || postUpdateDto.getContents().length() < 5) {
            bindingResult.addError(new FieldError("post", "contents", "5글자 이상 입력하세요."));
        }

        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            // 오류 메시지와 함께 사용자의 입력값을 RedirectAttributes에 추가
            model.addAttribute("post", postUpdateDto);
            return "posts/editForm"; // 같은 수정 폼 뷰 반환
        }
        postService.update(postId, postUpdateDto);

        return "redirect:/posts/" + postId;
    }

    @PostMapping("/{postId}/delete")
    public String delete(@PathVariable Long postId) {
        postService.delete(postId);

        return "redirect:/posts/list";
    }

}
