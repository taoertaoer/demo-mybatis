package com.xdd.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.xdd.common.GeneralResponse;
import com.xdd.dao.UserMapper;
import com.xdd.entity.User;
import com.xdd.service.IUserService;

@Service("userService")
@Transactional
public class UserService implements IUserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		record.setCreateTime(new Date());
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		record.setCreateTime(new Date());
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		User u = userMapper.selectByPrimaryKey(id);
		return u;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<User> getUsers(String startTime, String endTime, User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("username", user.getUsername());
		List<User> users = userMapper.getUsers(map);
		return users;
	}

	@Override
	public User getUser(User user) {
		User u = userMapper.getUser(user);
		return u;
	}

	@Override
	public GeneralResponse<List<User>> findByPaging(String startTime, String endTime, String username, Integer pageNum,
			Integer pageSize) {
		// PageHelper.startPage(pageNum,pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("username", username);
		Page<User> userList = userMapper.findByPaging(map);
		System.out.println(userList);
		return new GeneralResponse<List<User>>("1", "查询成功", "查询成功", userList);
	}
}
