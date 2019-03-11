package com.xdd.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.xdd.common.GeneralResponse;
import com.xdd.entity.User;

public interface IUserService {
	int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> getUsers(String startTime, String endTime, User user);
    
    GeneralResponse<List<User>> findByPaging(String startTime, String endTime, String username, Integer pageNum, Integer pageSize);
    
    User getUser(User user);
}
