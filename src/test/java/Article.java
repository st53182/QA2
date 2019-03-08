package model;

public class Article {
    private String title;
    private Integer commentCount;
    private Integer anonCommentCountCommentPage;
    private Integer RegCommentCountCommentPage;

    public Integer getAnonCommentCountCommentPage() {
        return anonCommentCountCommentPage;
    }

    public Integer getRegCommentCountCommentPage() {
        return RegCommentCountCommentPage;
    }

    public void setAnonCommentCountCommentPage(Integer anonCommentCountCommentPage) {
        this.anonCommentCountCommentPage = anonCommentCountCommentPage;
    }
    public void setAnonCommentCountCommentPage(String anonCommentCountCommentPage) {
        anonCommentCountCommentPage = anonCommentCountCommentPage.substring(1, anonCommentCountCommentPage.length() - 1);
        this.anonCommentCountCommentPage = Integer.valueOf(anonCommentCountCommentPage);
    }

    public void setRegCommentCountCommentPage(Integer regCommentCountCommentPage) {
        RegCommentCountCommentPage = regCommentCountCommentPage;
    }
    public void setRegCommentCountCommentPage(String RegCommentCountCommentPage) {
        RegCommentCountCommentPage = RegCommentCountCommentPage.substring(1, RegCommentCountCommentPage.length() - 1);
        this.RegCommentCountCommentPage = Integer.valueOf(RegCommentCountCommentPage);
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public void setCommentCount(String commentCount) {
        commentCount = commentCount.substring(1, commentCount.length() - 1);
        this.commentCount = Integer.valueOf(commentCount);
    }


}
