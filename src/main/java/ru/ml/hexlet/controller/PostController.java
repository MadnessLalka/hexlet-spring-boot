package ru.ml.hexlet.controller;

import org.springframework.web.bind.annotation.*;
import ru.ml.hexlet.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private final List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public List<Post> index(@RequestParam(defaultValue = "10") Integer limit) {
        return posts.stream().limit(limit).toList();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> show(@PathVariable String id) {
        return posts.stream()
                .filter(p -> p.getTitle().equals(id))
                .findFirst();
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        if (!postValidation(post)) return null;

        posts.add(post);
        return post;
    }

    @PutMapping("/posts/{id}")
    public Post update(@PathVariable String id, @RequestBody Post data) {
        if (!postValidation(data)) return null;

        var maybePost = posts.stream()
                .filter(p -> p.getTitle().equals(id))
                .findFirst();

        if (maybePost.isPresent()) {
            var post = maybePost.get();

            post.setAuthor(data.getAuthor());
            post.setContent(data.getContent());
            post.setTitle(data.getTitle());
            post.setCreateAt(data.getCreateAt());
        }

        return data;
    }

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getTitle().equals(id));
    }

    private boolean postValidation(Post post){
        return !post.getTitle().isBlank() && !post.getContent().isBlank();
    }
}
