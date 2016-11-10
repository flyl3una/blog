package com.blog.controller;

import com.blog.pojo.Article;
import com.blog.pojo.Catalogue;
import com.blog.pojo.Label;
import com.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ArticleOfCatalogueService articleOfCatalogueService;
    @Autowired
    private ArticleOfLabelService articleOfLabelService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String blogIndex(Model model){
        List<Article> articles = articleService.getAllArticle();
        List<Catalogue> catalogues = catalogueService.getAllCatalogues();
        List<Label> labels = labelService.getAllLabels();
        model.addAttribute("articles", articles);
        model.addAttribute("catalogues", catalogues);
        model.addAttribute("labels", labels);
        Map<Integer, List<String>> labelsMap = new HashMap<Integer, List<String>>();
        for (Article article : articles) {
            int articleId = article.getId();
            Integer[] labelsId = articleOfLabelService.findLabelsIdByArticleId(articleId);
            List<String> labelsName = new ArrayList<String>();
            for (int labelId : labelsId) {
                String labelName = labelService.findNameById(labelId);
                labelsName.add(labelName);
            }
            labelsMap.put(articleId, labelsName);
        }
        model.addAttribute("labelsMap", labelsMap);
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
        List<Catalogue> catalogues = catalogueService.getAllCatalogues();
        List<Label> labels = labelService.getAllLabels();
        model.addAttribute("catalogues", catalogues);
        model.addAttribute("labels", labels);
        return "/blog/article";
    }

    @RequestMapping(value = "/catalogue", method = RequestMethod.GET)
    public String getArticlesByCatalogue(@RequestParam("name")String name, Model model){
        try{
            int catalogueId = catalogueService.findIdByName(name);
            Integer[] articlesId = articleOfCatalogueService.findArticlesIdByCatalogueId(catalogueId);
            List<Article> articles = new ArrayList<Article>();
            for(int id:articlesId){
                Article article = articleService.findArticleById(id);
                articles.add(article);
            }
            List<Catalogue> catalogues = catalogueService.getAllCatalogues();
            List<Label> labels = labelService.getAllLabels();
            model.addAttribute("articles", articles);
            model.addAttribute("catalogues", catalogues);
            model.addAttribute("labels", labels);
        }catch (Exception e){
            e.printStackTrace();
            return "error/404";
        }
        return "/blog/index";
    }

    @RequestMapping(value = "/label", method = RequestMethod.GET)
    public String getArticlesByLabel(@RequestParam("name")String name, Model model){
        try{
            int labelId = labelService.findIdByName(name);
            Integer[] articlesId = articleOfLabelService.findArticlesIdByLabelId(labelId);
            List<Article> articles = new ArrayList<Article>();
            for(int id:articlesId){
                Article article = articleService.findArticleById(id);
                articles.add(article);
            }
            List<Catalogue> catalogues = catalogueService.getAllCatalogues();
            List<Label> labels = labelService.getAllLabels();
            model.addAttribute("articles", articles);
            model.addAttribute("catalogues", catalogues);
            model.addAttribute("labels", labels);
        }catch (Exception e){
            e.printStackTrace();
            return "error/404";
        }
        return "/blog/index";
    }

//    @RequestMapping(value = "search", method = RequestMethod.GET)
//    public String search(Model model, @RequestParam("text")String text){
//
//
//    }
}
