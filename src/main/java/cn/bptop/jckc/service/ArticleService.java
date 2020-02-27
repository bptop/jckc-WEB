package cn.bptop.jckc.service;

import cn.bptop.jckc.dao.ArticleDao;
import cn.bptop.jckc.dao.FileDao;
import cn.bptop.jckc.entity.Article;
import cn.bptop.jckc.entity.File;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
     * 通过文章类型查询文章实体
     *
     * @param type 文章类型
     * @return: 返回文章list
     * @time: 2020/2/23 11:23
     */
    public List queryAllbyType(String type, int pageNum, int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        Article article = new Article();
        article.setAClassify(type);
        return new PageInfo(articleDao.queryAll(article)).getList();
    }

    /**
     * 通过文章类型查询文章总数
     *
     * @param type 文章类型
     * @return: 返回文章总数
     * @time: 2020/2/27 19:23
     */
    public int queryCount(String type)
    {
        Article article = new Article();
        article.setAClassify(type);
        return articleDao.queryCount(article);
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
