package com.xdd.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.xdd.common.GeneralResponse;
import com.xdd.dao.ChatMapper;
import com.xdd.dao.ChatUserMapper;
import com.xdd.entity.Chat;
import com.xdd.entity.ChatUser;
import com.xdd.service.IChatService;

@Service("chatService")
@Transactional
public class ChatService implements IChatService {

	@Resource
	private ChatMapper chatMapper;
	
	@Resource
	private ChatUserMapper chatUserMapper;

	@Override
	public GeneralResponse<List<Map<String, Object>>> showChatsByPaging(Integer userId, Integer pageNum,
			Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", userId);
		map.put("pageNum", pageNum);
		map.put("pageSize", pageSize);
		List<Map<String, Object>> list = chatMapper.showChatsByPaging(map);
		return new GeneralResponse<List<Map<String, Object>>>("1", "查询成功", "查询成功", list);
	}

	@Override
	public GeneralResponse<Chat> addChat(String chatName, Integer userId, Integer[] userIds) {
		Chat chat = new Chat();
		chat.setChatName(chatName);
		chat.setCreaterId(userId);
		chat.setCreateTime(new Date());
		if(userIds.length==1) {
			chat.setIsGroup(0);
		}else {
			chat.setIsGroup(1);
		}
		chat.setIsValid(1);
		//chat.set
		chatMapper.insertBatchReturnId(chat);
		for(Integer id : userIds) {
			ChatUser cu = new ChatUser();
			cu.setChatId(chat.getId());
			cu.setCreaterId(userId);
			cu.setCreateTime(new Date());
			cu.setFriendId(id);
			cu.setIsValid(1);
			cu.setUserId(userId);
			chatUserMapper.insert(cu);
		}
		for(int i = 0, l = userIds.length; i<l; i++) {
			Integer[] ids = new Integer[l];
			ids=userIds.clone();
			Integer id=new Integer(userIds[i]);
			ids[i]=userId;
			for(int m = 0,n = ids.length; m<n; m++) {
				ChatUser cu = new ChatUser();
				cu.setChatId(chat.getId());
				cu.setCreaterId(userId);
				cu.setCreateTime(new Date());
				cu.setFriendId(ids[m]);
				cu.setIsValid(1);
				cu.setUserId(id);
				chatUserMapper.insert(cu);
			}
		}
		return new GeneralResponse<Chat>("1", "查询成功", "查询成功", chat);
	}

}
