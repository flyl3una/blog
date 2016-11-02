package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(HttpSession session) {
        return "/manage/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index1(HttpSession session) {
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
            Pattern p = Pattern.compile("(<.*>)+");
            Matcher m = p.matcher(article.getContent());
            String simple = m.replaceAll("").trim();
//            System.out.println(simple);
            article.setSimple(simple);
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

    @RequestMapping(value = "add_label", method = RequestMethod.POST)
    public String submitLabel(Label label){
        labelService.addLabel(label);
        return "redirect:/manage/article_label";
    }

    @RequestMapping(value = "add_catalogue", method = RequestMethod.POST)
    public String submitCatalogue(Catalogue catalogue){
        catalogueService.addCatalogue(catalogue);
        return "redirect:/manage/article_catalogue";
    }

    @RequestMapping(value = "delete_catalogues", method = RequestMethod.POST)
    public String deleteCatalogues(HttpServletRequest request) {
        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String paramName = (String) names.nextElement();
            int id = Integer.parseInt(paramName);
            catalogueService.deleteCatalogueById(id);
        }
        return "redirect:article_catalogue";
    }

    @RequestMapping(value = "delete_labels", method = RequestMethod.POST)
    public String deleteLabels(HttpServletRequest request) {
        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String paramName = (String) names.nextElement();
            int id = Integer.parseInt(paramName);
            labelService.deleteLabelById(id);
        }
        return "redirect:article_label";
    }

    @RequestMapping(value = "delete_catalogue", method = RequestMethod.GET)
    public String deleteCatalogue(@RequestParam("id") int id) {
        catalogueService.deleteCatalogueById(id);
        return "redirect:article_catalogue";
    }

    @RequestMapping(value = "delete_label", method = RequestMethod.GET)
    public String deleteLabel(@RequestParam("id") int id) {
        labelService.deleteLabelById(id);
        return "redirect:article_label";
    }

    @ResponseBody
    @RequestMapping(value = "update_catalogue", method = RequestMethod.GET)
    public String updateCatalogue(@RequestParam("id") int id, @RequestParam("name") String name) {
        Catalogue catalogue = catalogueService.findCatalogueById(id);
        catalogue.setName(name);
        try {
            catalogueService.updateCatalogue(catalogue);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "success");
            return jsonObject.toString();
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "error");
            String old_name = catalogueService.findNameById(catalogue.getId());
            jsonObject.put("old_name", old_name);
            return jsonObject.toString();
        }
    }

    @ResponseBody
    @RequestMapping(value = "update_label", method = RequestMethod.GET)
    public String updateLabel(@RequestParam("id") int id, @RequestParam("name") String name) {
        Label label = labelService.findLabelById(id);
        label.setName(name);
        try {
            labelService.updateLabel(label);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "success");
            return jsonObject.toString();
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "error");
            String old_name = labelService.findNameById(label.getId());
            jsonObject.put("old_name", old_name);
            return jsonObject.toString();
        }
    }

}
