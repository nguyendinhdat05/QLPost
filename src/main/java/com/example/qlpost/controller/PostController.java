package com.example.qlpost.controller;

import com.example.qlpost.model.Post;
import com.example.qlpost.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Post post) {
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, Post post) {
        post.setId(id);
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postRepository.deleteById(id);
        return new ResponseEntity<>("done delete", HttpStatus.OK);
    }

    @GetMapping("/only/{id}")
    public ResponseEntity findPostByUser(@PathVariable Long id) {
        return new ResponseEntity<>(postRepository.findByUserIdAndStatus(id, "Only Me"), HttpStatus.OK);
    }

    @GetMapping("/sortLike")
    public ResponseEntity sortLike() {
        return new ResponseEntity<>(postRepository.findAllByOrderByLikesAsc(), HttpStatus.OK);
    }


    @GetMapping("/top-like")
    public ResponseEntity getTop4LikePost(){
        return new ResponseEntity<>(postRepository.findTop4ByStatusOrderByLikesDesc("Public"),HttpStatus.OK);
    }
}
