package com.xdd.dao;

import java.util.List;
import java.util.Map;

import com.xdd.entity.Chat;

public interface ChatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chat record);

    int insertSelective(Chat record);

    Chat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chat record);

    int updateByPrimaryKey(Chat record);
    
    List<Map<String, Object>> showChatsByPaging(Map<String, Object> map);
    
    void insertBatchReturnId(Chat chat);
}