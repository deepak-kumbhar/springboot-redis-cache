package com.example.redis.controller;

import com.example.redis.entity.Post;
import com.example.redis.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    /**
     * Save post
     *
     * @param post
     * @return
     */
    @PostMapping
    public String savePost(@RequestBody List<Post> post) {
        postRepository.saveAll(post);
        return post.size() + " post added";
    }

    /**
     * Get all post
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Post>> getAllPost() {
        System.out.println("Getting data from DB ");
        return ResponseEntity.ok(postRepository.findAll());
    }

    /**
     * Get single record
     *
     * @param id
     * @return
     */
    @GetMapping("/single/{id}")
    @Cacheable(value = "post", key = "#id")
    public Post getSinglePost(@PathVariable(value = "id") Integer id) {
        System.out.println("Getting data from DB ");
        return postRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Post not found" + id));
    }

    /**
     * Update post
     *
     * @param post
     * @return
     */
    @PutMapping("/{id}")
    @CachePut(value = "post", key = "#id")
    public Post updatePost(@PathVariable(value = "id") Integer id,@RequestBody Post post) {
        Post employee = postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Post not found for this id :: " + id));

        return postRepository.save(employee);
    }


    /**
     * delete post
     *
     * @param
     * @return
     */
    @DeleteMapping
    @CacheEvict(value = "post", allEntries = true)
    public void deletePost(@PathVariable(value = "id") Integer id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found :: " + id));
        postRepository.delete(post);
    }
}
