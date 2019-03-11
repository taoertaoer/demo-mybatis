package com.xdd.entity;

public class FriendDelete {
    private Integer id;

    private Integer userId;

    private Integer friendId;

    private Integer blacklistUser;

    private Integer blacklistFriend;

    private Integer removeUser;

    private Integer removeFriend;

    private Integer isValid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getBlacklistUser() {
        return blacklistUser;
    }

    public void setBlacklistUser(Integer blacklistUser) {
        this.blacklistUser = blacklistUser;
    }

    public Integer getBlacklistFriend() {
        return blacklistFriend;
    }

    public void setBlacklistFriend(Integer blacklistFriend) {
        this.blacklistFriend = blacklistFriend;
    }

    public Integer getRemoveUser() {
        return removeUser;
    }

    public void setRemoveUser(Integer removeUser) {
        this.removeUser = removeUser;
    }

    public Integer getRemoveFriend() {
        return removeFriend;
    }

    public void setRemoveFriend(Integer removeFriend) {
        this.removeFriend = removeFriend;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}