package com.xdd.dao;

import com.xdd.entity.FriendDelete;

public interface FriendDeleteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FriendDelete record);

    int insertSelective(FriendDelete record);

    FriendDelete selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FriendDelete record);

    int updateByPrimaryKey(FriendDelete record);
}