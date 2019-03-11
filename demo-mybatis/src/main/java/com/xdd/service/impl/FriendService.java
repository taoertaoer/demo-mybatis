package com.xdd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.xdd.common.GeneralResponse;
import com.xdd.dao.FriendMapper;
import com.xdd.dao.UserMapper;
import com.xdd.entity.Friend;
import com.xdd.entity.User;
import com.xdd.service.IFriendService;

@Service("friendService")
@Transactional
public class FriendService implements IFriendService {

	@Resource
	private FriendMapper friendMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public GeneralResponse<List<Friend>> showFriendsByPaging(Integer userId, Integer pageNum, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		List<Friend> list = friendMapper.showFriendsByPaging(map);
		return new GeneralResponse<List<Friend>>("1", "查询成功", "查询成功", list);
	}

	@Override
	public GeneralResponse<User> addFriend(Friend friend) {
		int i = friendMapper.insert(friend);
		if(i != 0) {
			User user =userMapper.selectByPrimaryKey(friend.getFriendId());
			return new GeneralResponse<User>("1", "查询成功", "查询成功", user);
		}
		return new GeneralResponse<User>("1", "查询成功", "查询成功", null);
	}

}
