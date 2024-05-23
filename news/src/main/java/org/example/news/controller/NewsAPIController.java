package org.example.news.controller;

import org.example.news.model.News;
import org.example.news.model.NewsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsAPIController {
    private final NewsDAO newsDAO;

    @Autowired
    public NewsAPIController(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @PostMapping
    public String addNews(@RequestBody News news) {
        try {
         newsDAO.addNews(news);
        } catch (Exception e) {
            e.printStackTrace();
            return "News API: 뉴스 등록 실패";
        }
        return "News API: 뉴스 등록 성공";
    }

    @DeleteMapping("/{aid}")
    public String deleteNews(@PathVariable int aid) {
        try {
            newsDAO.delNews(aid);
        } catch (Exception e) {
            e.printStackTrace();
            return "News API: 뉴스 삭제 실패 - " + aid;
        }
        return "News API: 뉴스 삭제 성공";
    }

    @GetMapping
    public List<News> list() {
        List<News> newslist = null;
        try {
            newslist = newsDAO.getAll();
            return newslist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newslist;
    }

    @GetMapping("/{aid}")
    public News getNews(@PathVariable int aid) {
        News news = null;
        try {
            news = newsDAO.getNews(aid);
            return news;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }


}
