package com.xdd.dao;

import com.xdd.entity.ChatUser;

public interface ChatUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChatUser record);

    int insertSelective(ChatUser record);

    ChatUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChatUser record);

    int updateByPrimaryKey(ChatUser record);
}