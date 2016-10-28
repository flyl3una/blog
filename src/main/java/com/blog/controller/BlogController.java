package com.blog.controller;

import com.blog.pojo.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by fly_l on 2016/10/24.
 */

@Controller
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String blogIndex(Model model){
        List<Article> articles = articleService.getAllArticle();
        model.addAttribute("articles", articles);
        return "/blog/index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String blogIndex1(Model model){
        List<Article> articles = articleService.getAllArticle();
        model.addAttribute("articles", articles);
        return "/blog/index";
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String article(@RequestParam(value = "id")int id, Model model){
        Article article = articleService.findArticleById(id);
        model.addAttribute("article", article);
        return "/blog/article";
    }
}
