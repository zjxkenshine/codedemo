package com.kenshine.pie;

/**
 * 入参DTO，Command代表会执行修改操作
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
public class ArticleTitleModifyCmd {

    private String articleId;

    private String title;

    private String content;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
