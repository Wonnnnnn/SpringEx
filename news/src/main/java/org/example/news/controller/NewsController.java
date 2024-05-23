package org.example.news.controller;

import org.example.news.model.News;
import org.example.news.model.NewsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
//    @Autowired
    private NewsDAO newsDAO;

//    @Autowired
    public NewsController(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @GetMapping("/list")
    public String list(Model model) {
        try {
            List<News> newsList = newsDAO.getAll();
            model.addAttribute("newsList", newsList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "newsList";
    }

    @GetMapping("/addNews")
    public String addNews(News news, Model model) {
        try {
            news.setTitle("title");
            news.setContent("content");

//            if (!news.getImg().isEmpty()) {
//                // 파일 저장 경로 설정
//                String fileName = news.getImg().getOriginalFilename();
//                String filePath = "path/to/save/directory/" + fileName;
//                File dest = new File(filePath);
//                news.getImg().transferTo(dest);
//                news.setImg(filePath);
//            }
            newsDAO.addNews(news);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/news/list";
    }

    @GetMapping("/deleteNews/{aid}")
    public String deleteNews(@PathVariable int aid) {
        try {
            newsDAO.delNews(aid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/news/list";
    }

    @GetMapping("/getNews/{aid}")
    public String getNews(@PathVariable("aid") int aid,
                          Model model) {
        try {
            News news = newsDAO.getNews(aid);
            model.addAttribute("news", news);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "newsView";
    }


}
