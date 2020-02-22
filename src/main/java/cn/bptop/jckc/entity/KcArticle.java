package cn.bptop.jckc.entity;

import java.io.Serializable;

/**
 * (KcArticle)实体类
 *
 * @author makejava
 * @since 2020-02-20 10:42:43
 */
public class KcArticle implements Serializable
{
    private static final long serialVersionUID = 467448255597708991L;
    /**
     * 文章id
     */
    private Integer aArticleId;
    /**
     * 作者
     */
    private String aAuthor;
    /**
     * 发表时间
     */
    private String aPublishTime;
    /**
     * 发表部门
     */
    private String aPublishDepartment;
    /**
     * 发布人
     */
    private Integer userId;
    /**
     * 文章分类
     */
    private String aClassify;
    /**
     * 文章内容
     */
    private String aContent;

    public Integer getAArticleId()
    {
        return aArticleId;
    }

    public void setAArticleId(Integer aArticleId)
    {
        this.aArticleId = aArticleId;
    }

    public String getAAuthor()
    {
        return aAuthor;
    }

    public void setAAuthor(String aAuthor)
    {
        this.aAuthor = aAuthor;
    }

    public String getAPublishTime()
    {
        return aPublishTime;
    }

    public void setAPublishTime(String aPublishTime)
    {
        this.aPublishTime = aPublishTime;
    }

    public String getAPublishDepartment()
    {
        return aPublishDepartment;
    }

    public void setAPublishDepartment(String aPublishDepartment)
    {
        this.aPublishDepartment = aPublishDepartment;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getAClassify()
    {
        return aClassify;
    }

    public void setAClassify(String aClassify)
    {
        this.aClassify = aClassify;
    }

    public String getAContent()
    {
        return aContent;
    }

    public void setAContent(String aContent)
    {
        this.aContent = aContent;
    }
}