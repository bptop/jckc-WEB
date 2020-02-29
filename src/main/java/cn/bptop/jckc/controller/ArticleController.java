package cn.bptop.jckc.controller;

import cn.bptop.jckc.service.ArticleService;
import cn.bptop.jckc.until.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
public class ArticleController
{
    @Autowired
    ArticleService articleService;

    @ResponseBody
    @RequestMapping("/articleList")
    public String articleList(String type, int pageNum, int pageSize)
    {
        return Json.toJson(articleService.wipeContent(articleService.queryAllbyType(type, pageNum, pageSize)));
    }

    @ResponseBody
    @RequestMapping("/size")
    public String size(String type)
    {
        return Json.toJson(articleService.queryCount(type));
    }

    @ResponseBody
    @RequestMapping("/article")
    public String article(String id)
    {
        return Json.toJson(articleService.queryById(Integer.parseInt(id)));
    }
}
