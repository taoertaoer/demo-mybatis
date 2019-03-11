package com.xdd.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.xdd.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    
    Page<User> findByPaging(Map<String, Object> map);
    
    List<User> getUsers(Map<String, Object> map);
    
    User getUser(User user);
}