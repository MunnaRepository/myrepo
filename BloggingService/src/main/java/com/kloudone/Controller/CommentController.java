package com.kloudone.Controller;

import com.kloudone.model.Comment;
import com.kloudone.model.Post;
import com.kloudone.model.User;
import com.kloudone.services.CommentService;
import com.kloudone.services.PostService;
import com.kloudone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
public class CommentController {

    private final PostService postService;
    private final UserService userService;
    private final CommentService commentService;

    @Autowired
    public CommentController(PostService postService, UserService userService, CommentService commentService) {
        this.postService = postService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
    public String createNewPost(@Valid Comment comment,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/commentForm";

        } else {
            commentService.save(comment);
            return "redirect:/post/" + comment.getPost().getId();
        }
    }

    @RequestMapping(value = "/commentPost/{id}", method = RequestMethod.GET)
    public String commentPostWithId(@PathVariable Long id,
                                    Principal principal,
                                    Model model) {

        Optional<Post> post = postService.findForId(id);

        if (post.isPresent()) {
            Optional<User> user = userService.findByUsername(principal.getName());

            if (user.isPresent()) {
                Comment comment = new Comment();
                comment.setUser(user.get());
                comment.setPost(post.get());

                model.addAttribute("comment", comment);

                return "/commentForm";

            } else {
                return "/error";
            }

        } else {
            return "/error";
        }
    }

}
