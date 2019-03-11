package com.xdd.service;

import java.util.List;

import com.xdd.common.GeneralResponse;
import com.xdd.entity.Friend;
import com.xdd.entity.User;

public interface IFriendService {

	GeneralResponse<List<Friend>> showFriendsByPaging(Integer userId,  Integer pageNum,Integer pageSize);

	GeneralResponse<User> addFriend(Friend friend);
}
