package com.blog.controller;

import com.blog.pojo.Article;
import com.blog.pojo.Catalogue;
import com.blog.pojo.Label;
import com.blog.service.ArticleService;
import com.blog.service.CatalogueService;
import com.blog.service.LabelService;
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
    @Autowired
    private CatalogueService catalogueService;
    @Autowired
    private LabelService labelService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String blogIndex(Model model){
        List<Article> articles = articleService.getAllArticle();
        List<Catalogue> catalogues = catalogueService.getAllCatalogue();
        List<Label> labels = labelService.getAllLabels();
        model.addAttribute("articles", articles);
        model.addAttribute("catalogues", catalogues);
        model.addAttribute("labels", labels);
        return "/blog/index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String blogIndex1(){
        return "redirect:/";
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String article(@RequestParam(value = "id")int id, Model model){
        Article article = articleService.findArticleById(id);
        model.addAttribute("article", article);
        return "/blog/article";
    }

    @RequestMapping(value = "/catalogue", method = RequestMethod.GET)
    public String getArticlesByCatalogue(@RequestParam("name")String name, Model model){
        return "/blog/index";
    }

    @RequestMapping(value = "/label", method = RequestMethod.GET)
    public String getArticlesByLabel(@RequestParam("name")String name, Model model){
        return "/blog/index";
    }
}
