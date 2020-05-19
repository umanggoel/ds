package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class Post {

	Long id;
	String title;
	String content;

}

@Component
class PostRepository		{
	private static final Map<Long, Post> DATA = new HashMap<Long, Post>();
	private static long ID_COUNTER = 1;
	static {
			long id = ID_COUNTER++;
			Post p = new Post();
			p.id = id;
			DATA.put(Long.valueOf(id), p);
	}
 	
 	Flux<Post> findAll() {return Flux.fromIterable(DATA.values());}
	
	Mono<Post> findById(Long id) {return Mono.just(DATA.get(id));}

	Mono<Post> createPost(Post post) {
		long id = ID_COUNTER++;
		post.id = id;
		DATA.put(id, post);
		return Mono.just(post);
		
	}
}

@RestController
@RequestMapping(value = "/posts")
class PostController {
    
    private final PostRepository posts;

    public PostController(PostRepository posts) {
        this.posts = posts;
    }

    @GetMapping(value = "")
    public Flux<Post> all() {
        return this.posts.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Post> get(@PathVariable(value = "id") Long id) {
        return this.posts.findById(id);
    }
    
    @PostMapping(value = "")
    public Mono<Post> create(Post post) {
        return this.posts.createPost(post);
    }
   
}

@Configuration
@ComponentScan
@EnableWebFlux
class WebConfig {

}