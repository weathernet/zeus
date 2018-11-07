package com.zcf.universe.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "home_story")
public class HomeStory {
    /**
     * 故事Id
     */
    @Column(name = "story_id")
    private String storyId;

    /**
     * 故事标题
     */
    @Column(name = "story_title")
    private String storyTitle;

    @Column(name = "story_content")
    private String storyContent;

    /**
     * 故事图片
     */
    @Column(name = "story_image")
    private String storyImage;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取故事Id
     *
     * @return story_id - 故事Id
     */
    public String getStoryId() {
        return storyId;
    }

    /**
     * 设置故事Id
     *
     * @param storyId 故事Id
     */
    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    /**
     * 获取故事标题
     *
     * @return story_title - 故事标题
     */
    public String getStoryTitle() {
        return storyTitle;
    }

    /**
     * 设置故事标题
     *
     * @param storyTitle 故事标题
     */
    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    /**
     * @return story_content
     */
    public String getStoryContent() {
        return storyContent;
    }

    /**
     * @param storyContent
     */
    public void setStoryContent(String storyContent) {
        this.storyContent = storyContent;
    }

    /**
     * 获取故事图片
     *
     * @return story_image - 故事图片
     */
    public String getStoryImage() {
        return storyImage;
    }

    /**
     * 设置故事图片
     *
     * @param storyImage 故事图片
     */
    public void setStoryImage(String storyImage) {
        this.storyImage = storyImage;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}