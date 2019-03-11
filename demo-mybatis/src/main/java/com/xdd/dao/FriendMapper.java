package com.xdd.dao;

import java.util.List;
import java.util.Map;

import com.xdd.entity.Chat;
import com.xdd.entity.Friend;

public interface FriendMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Friend record);

	int insertSelective(Friend record);

	Friend selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Friend record);

	int updateByPrimaryKey(Friend record);

	List<Friend> showFriendsByPaging(Map<String, Object> map);
}