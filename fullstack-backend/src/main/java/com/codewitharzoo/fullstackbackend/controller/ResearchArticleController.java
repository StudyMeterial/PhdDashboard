package com.codewitharzoo.fullstackbackend.controller;
import com.codewitharzoo.fullstackbackend.model.ResearchArticle;
import com.codewitharzoo.fullstackbackend.repository.ResearchArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
@CrossOrigin("http://localhost:3000")
public class ResearchArticleController {

    private final ResearchArticleRepository articleRepository;

    @Autowired
    public ResearchArticleController(ResearchArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @PostMapping("/save")
    public ResearchArticle saveArticle(@RequestBody ResearchArticle article) {
        return articleRepository.save(article);
    }

    @GetMapping("/all")
    public Iterable<ResearchArticle> getAllArticles() {
        return articleRepository.findAll();
    }
}
