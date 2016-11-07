package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blog.pojo.*;
import com.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
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
    @Autowired
    private ArticleOfCatalogueService articleOfCatalogueService;
    @Autowired
    private ArticleOfLabelService articleOfLabelService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(HttpSession session) {
        return "/manage/index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index1(HttpSession session) {
        return "/manage/index";
    }

    @RequestMapping(value = "article_list", method = RequestMethod.GET)
    public String articleList(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        try {
            List<Article> articles = articleService.getAllArticle();
            Map<Integer, String> catalogues = new HashMap<Integer, String>();
            Map<Integer, List<String>> labels = new HashMap<Integer, List<String>>();
            for (int i = (page - 1) * 10; i < (articles.size() < page * 10 ? articles.size() : page * 10); i++) {
                Article article = articles.get(i);
                int catalogueId = articleOfCatalogueService.findCatalogueIdByArticleId(article.getId());
                Catalogue catalogue = catalogueService.findCatalogueById(catalogueId);
                catalogues.put(article.getId(), catalogue.getName());
                Integer[] labelsId = articleOfLabelService.findLabelsIdByArticleId(article.getId());
                List<String> labelsName = new ArrayList<String>();
                for (int labelId : labelsId) {
                    Label label = labelService.findLabelById(labelId);
                    labelsName.add(label.getName());
                }
                labels.put(article.getId(), labelsName);
            }
            model.addAttribute("articles", articles);
            model.addAttribute("catalogues", catalogues);
            model.addAttribute("labels", labels);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/manage/article_list";
    }

    @RequestMapping(value = "write_article", method = RequestMethod.GET)
    public String writeArticle(Model model){
        List<Label> labels = labelService.getAllLabels();
        List<Catalogue> catalogues = catalogueService.getAllCatalogues();
        model.addAttribute("catalogues", catalogues);

        model.addAttribute("labels", labels);
        model.addAttribute("update", false);
        return "/manage/write_article";
    }

    @RequestMapping(value = "write_article", method = RequestMethod.POST)
    public String writeArticle(Article article,
                               @RequestParam("catalogueId")int catalogueId,
                               @RequestParam("labelsId")String labelsId,
                               Model model){
        try{

            String regEx = "<[^>]+>#";
            Pattern   p   =   Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
            Matcher   m   =   p.matcher(article.getContent());
            String simple=m.replaceAll("").trim();
            int len = (simple.length()>20?20:simple.length());
            article.setSimple(simple.substring(0, len));
            ArtOfCatalogue artOfCatalogue = new ArtOfCatalogue();
            if (catalogueId == 0) {
                try {
                    catalogueId = catalogueService.findIdByName("");
                } catch (Exception e) {
                    Catalogue catalogue = new Catalogue();
                    catalogue.setName("");
                    catalogueService.addCatalogue(catalogue);
                    catalogueId = catalogueService.findIdByName("");
                }
            }
            if(article.getId() != 0){
                articleService.updateArticle(article);
                artOfCatalogue.setArticle_id(article.getId());
                artOfCatalogue.setCatalogue_id(catalogueId);
                articleOfCatalogueService.updateArticleOfCatalogue(artOfCatalogue);
                articleOfLabelService.deleteArticleOfLabel(article.getId());
            }
            else{
                articleService.addArticle(article);
                artOfCatalogue.setArticle_id(article.getId());
                artOfCatalogue.setCatalogue_id(catalogueId);
                articleOfCatalogueService.addArticleOfCatalogue(artOfCatalogue);
            }
            if (!labelsId.equalsIgnoreCase("")) {
                String[] labelId = labelsId.split(",");
                for (String idStr : labelId) {
                    int id = Integer.parseInt(idStr);
                    ArtOfLabel artOfLabel = new ArtOfLabel();
                    artOfLabel.setArticle_id(article.getId());
                    artOfLabel.setLabel_id(id);
                    articleOfLabelService.addArticleOfLabel(artOfLabel);
                }
            }
            return "redirect:/manage/article_list";
        }catch (Exception e){
            model.addAttribute("error", "文章发布失败");
            return "redirect:/manage/write_article";
        }
    }

    @RequestMapping(value = "article_catalogue", method = RequestMethod.GET)
    public String articleCatalogue(Model model){
        List<Catalogue> catalogues = catalogueService.getAllCatalogues();
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

    @RequestMapping(value = "delete_article", method = RequestMethod.GET)
    public String deleteArticle(@RequestParam("id") int id, Model model) {
        try {
            articleService.deleteArticle(id);
            articleOfCatalogueService.deleteArticleOfCatalogue(id);
            articleOfLabelService.deleteArticleOfLabel(id);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status", "success");
            return "redirect:/manage/article_list";
        } catch (Exception e) {
            model.addAttribute("error", "文章删除失败");
            return "redirect:/manage/article_list";
        }
    }

    @RequestMapping(value = "update_article", method = RequestMethod.GET)
    public String updateArticle(@RequestParam("id") int id, Model model) {
        Article article = articleService.findArticleById(id);
        int catalogueId = articleOfCatalogueService.findCatalogueIdByArticleId(id);
        Integer[] labelsId = articleOfLabelService.findLabelsIdByArticleId(id);
        List<Label> labels = labelService.getAllLabels();
        List<Catalogue> catalogues = catalogueService.getAllCatalogues();
        model.addAttribute("article", article);
        model.addAttribute("catalogueId", catalogueId);
        model.addAttribute("labelsId", labelsId);
        model.addAttribute("catalogues", catalogues);
        model.addAttribute("labels", labels);
        model.addAttribute("update", true);
        return "/manage/write_article";
    }

}
