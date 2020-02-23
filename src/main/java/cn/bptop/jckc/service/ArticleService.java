package cn.bptop.jckc.service;

import cn.bptop.jckc.dao.ArticleDao;
import cn.bptop.jckc.dao.FileDao;
import cn.bptop.jckc.entity.Article;
import cn.bptop.jckc.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService
{
    @Autowired
    ArticleDao articleDao;
    @Autowired
    FileDao fileDao;

    /**
     * @param type 文章类型
     * @return: 返回文章list
     * @time: 2020/2/23 11:23
     */
    public List<Article> queryAllbyType(String type, int offset, int limit)
    {
        Article article = new Article();
        article.setAClassify(type);
        return articleDao.queryAll(article, offset, limit);
    }

    /**
     * 去掉文章的正文,用于新闻列表
     *
     * @param
     * @return: 返回去掉正文的文章
     * @time: 2020/2/23 11:29
     */
    public List<Map> wipeContent(List<Article> articleList)
    {
        List<Map> list = new ArrayList();
        for ( Article article : articleList )
        {
            Map map = new HashMap();
            File file = new File();
            article.setAContent("");
            map.put("article", article);
            file.setAArticleId(article.getAArticleId());
            map.put("img", fileDao.queryAll(file, 0, 1));
            list.add(map);
        }
        return list;
    }
}
