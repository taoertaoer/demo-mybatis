package com.xdd.service;

import java.util.List;
import java.util.Map;

import com.xdd.common.GeneralResponse;
import com.xdd.entity.Chat;

public interface IChatService {

	GeneralResponse<List<Map<String, Object>>> showChatsByPaging(Integer userId,  Integer pageNum,Integer pageSize);

	GeneralResponse<Chat> addChat(String chatName, Integer userId, Integer[] userIds);
}
