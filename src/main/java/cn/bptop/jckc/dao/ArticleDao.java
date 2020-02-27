package cn.bptop.jckc.dao;

import cn.bptop.jckc.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (KcArticle)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-22 19:04:26
 */
@Repository
@Mapper
public interface ArticleDao
{

    /**
     * 通过ID查询单条数据
     *
     * @param aArticleId 主键
     * @return 实例对象
     */
    Article queryById(Integer aArticleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Article> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param article 实例对象
     * @return 对象列表
     */
    List<Article> queryAll(@Param("article") Article article);

    /**
     * 通过实体作为筛选条件查询count
     *
     * @param article 实例对象
     * @return 对象列表
     */
    int queryCount(@Param("article") Article article);

    /**
     * 新增数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int insert(Article article);

    /**
     * 修改数据
     *
     * @param article 实例对象
     * @return 影响行数
     */
    int update(Article article);

    /**
     * 通过主键删除数据
     *
     * @param aArticleId 主键
     * @return 影响行数
     */
    int deleteById(Integer aArticleId);

}