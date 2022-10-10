package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

@RestController
@RequestMapping("/post")
public class PostController {
   public List<Post> getJsonFile() throws IOException {
    String baseUrl = "https://jsonplaceholder.typicode.com/posts";
    HttpUrl.Builder httpUrl = HttpUrl.parse(baseUrl).newBuilder();
    String url = httpUrl.build().toString();
    Request request=new Request.Builder()
            .url(url)
            .build();
    OkHttpClient okHttpClient = new OkHttpClient();
    Call call = okHttpClient.newCall(request);
    Response response = call.execute();
    ObjectMapper objectMapper = new ObjectMapper();
    List<Post> posts = objectMapper.readValue(response.body().string(), new TypeReference<List<Post>>() {
    });
    return posts;
   }
        @GetMapping("/body_even_letters_sum")
        public Double getSum() throws IOException {
            return getJsonFile().stream()
                    .filter(post -> post.getBody().length() % 2 == 0)
                    .mapToDouble(post -> post.getBody().length())
                    .sum();
}
         @GetMapping("/posts_list")
         public List<Post> getPosts() throws IOException {
            return  getJsonFile().stream()
                    .filter(post -> post.getUserId()%2==0)
                    .collect(Collectors.toList());
    }
}
