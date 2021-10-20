package yte.intern.spring_web;

import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;


public class RestTemplateTest {

    RestTemplate restTemplate = new RestTemplate();

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Test
    public void tumPostlariAl(){
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> posts = restTemplate.exchange(requestEntity, Post[].class);

        List<Post> postList = Arrays.asList(posts.getBody());
        System.out.println(postList);
    }

    @Test
    public void idIlePostGetir() {
        URI uri = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post> posts = restTemplate.exchange(requestEntity, Post.class);

        System.out.println(posts.getBody());

    }


    @Test
    public void postEkle(){
        URI uri=UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .build()
                .toUri();

        Post newPost = new Post(4L, 120L, "hebele", "hubele");
        RequestEntity<Post> requestEntity = RequestEntity.post(uri).body(newPost);

        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);
        System.out.println(response.getBody());

    }

    @Test
    public void userIdIlePostGetir(){
        URI uri=UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts")
                .queryParam("userId",2)
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();

        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);

        System.out.println(Arrays.asList(response.getBody()));
    }

    @Test
    public void componentGuncelle(){
        URI uri=UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("comments","5")
                .build()
                .toUri();

        RequestEntity<Comment> requestEntity = RequestEntity.put(uri).body(new Comment(12L, 5L,"hebele","hubele@gmail.com","djshd"));
        ResponseEntity<Comment> response = restTemplate.exchange(requestEntity, Comment.class);

        System.out.println(response.getBody());

    }

    @Test
    public void postuSil(){
        URI uri=UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .pathSegment("posts","1")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.delete(uri).build();
        ResponseEntity<Void> response = restTemplate.exchange(requestEntity, void.class);
        System.out.println(response.getBody() + " "+" kdvkldfjdkfk");

    }




}
