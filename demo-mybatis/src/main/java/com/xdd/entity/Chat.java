package com.xdd.entity;

import java.util.Date;

public class Chat {
    private Integer id;

    private Integer createrId;

    private Date createTime;

    private Integer isGroup;

    private String chatName;

    private Integer isValid;

    private Date lastestTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Integer createrId) {
        this.createrId = createrId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Integer isGroup) {
        this.isGroup = isGroup;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName == null ? null : chatName.trim();
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Date getLastestTime() {
        return lastestTime;
    }

    public void setLastestTime(Date lastestTime) {
        this.lastestTime = lastestTime;
    }
}