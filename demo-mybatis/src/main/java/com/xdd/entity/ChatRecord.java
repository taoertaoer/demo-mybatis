package com.xdd.entity;

import java.util.Date;

public class ChatRecord {
    private Integer id;

    private Integer chatId;

    private Integer userId;

    private String content;

    private Date sendTime;

    private String type;

    private Integer isLastest;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getIsLastest() {
        return isLastest;
    }

    public void setIsLastest(Integer isLastest) {
        this.isLastest = isLastest;
    }
}