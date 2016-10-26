package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.blog.pojo.Article;
import com.blog.service.AdminService;
import com.blog.service.ArticleService;
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

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpSession session) {
        return "/manage/index";
    }

    @ResponseBody
    @RequestMapping(value = "show-article-list", method = RequestMethod.GET)
    public String show_article_list(){
        return "aaa";
    }

    @RequestMapping(value = "article_list", method = RequestMethod.GET)
    public String article_list(Model model){
        List<Article> articles = articleService.getAllArticle();
//        model.addAttribute("articles", JSON.toJSONString(articles));
        model.addAttribute("articles", articles);
        return "/manage/article_list";
    }

    @RequestMapping(value = "write_article", method = RequestMethod.GET)
    public String write_article(){
        return "/manage/write_article";
    }

    @RequestMapping(value = "write_article", method = RequestMethod.POST)
    public String write_article(Article article, Model model){
        try{
            articleService.addArticle(article);
            return "redirect:/manage/article_list";
        }catch (Exception e){
            model.addAttribute("error", "文章发布失败");
            return "redirect:/manage/write_article";
        }
    }

    @RequestMapping(value = "article_article_directory", method = RequestMethod.GET)
    public String article_kind(){
        return "/manage/article_article_directory";
    }

    @RequestMapping(value = "article_label", method = RequestMethod.GET)
    public String article_label(){
        return "/manage/article_label";
    }

}
