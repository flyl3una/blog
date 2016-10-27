package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.blog.pojo.Article;
import com.blog.pojo.Catalogue;
import com.blog.pojo.Label;
import com.blog.service.AdminService;
import com.blog.service.ArticleService;
import com.blog.service.CatalogueService;
import com.blog.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by fly_l on 2016/10/20.
 */

@Controller
@RequestMapping("manage")
public class ManageController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private CatalogueService catalogueService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpSession session) {
        return "/manage/index";
    }

    @ResponseBody
    @RequestMapping(value = "show-article-list", method = RequestMethod.GET)
    public String showArticleList(){
        return "aaa";
    }

    @RequestMapping(value = "article_list", method = RequestMethod.GET)
    public String articleList(Model model){
        List<Article> articles = articleService.getAllArticle();
//        model.addAttribute("articles", JSON.toJSONString(articles));
        model.addAttribute("articles", articles);
        return "/manage/article_list";
    }

    @RequestMapping(value = "write_article", method = RequestMethod.GET)
    public String writeArticle(){
        return "/manage/write_article";
    }

    @RequestMapping(value = "write_article", method = RequestMethod.POST)
    public String writeArticle(Article article, Model model){
        try{
            articleService.addArticle(article);
            return "redirect:/manage/article_list";
        }catch (Exception e){
            model.addAttribute("error", "文章发布失败");
            return "redirect:/manage/write_article";
        }
    }

    @RequestMapping(value = "article_catalogue", method = RequestMethod.GET)
    public String articleCatalogue(Model model){
        List<Catalogue> catalogues = catalogueService.getAllCatalogue();
        model.addAttribute("catalogues", catalogues);
        return "/manage/article_catalogue";
    }

    @RequestMapping(value = "article_label", method = RequestMethod.GET)
    public String articleLabel(Model model){
        List<Label> labels = labelService.getAllLabels();
        model.addAttribute("labels", labels);
        return "/manage/article_label";
    }

    @RequestMapping(value = "add-label", method = RequestMethod.POST)
    public String submitLabel(Label label){
        labelService.addLabel(label);
        return "redirect:/manage/article_label";
    }

    @RequestMapping(value = "add-catalogue", method = RequestMethod.POST)
    public String submitCatalogue(Catalogue catalogue){
        catalogueService.addCatalogue(catalogue);
        return "redirect:/manage/article_catalogue";
    }
}
