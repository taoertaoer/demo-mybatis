package com.xdd.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdd.common.GeneralResponse;
import com.xdd.entity.Chat;
import com.xdd.entity.User;
import com.xdd.service.IChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

	@Resource(name = "chatService")
	private IChatService chatService;

	@GetMapping("/showChatsByPaging.do")
	public GeneralResponse<List<Map<String, Object>>> showChatsByPaging(Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User u = (User) session.getAttribute("loginUser");
		System.out.println(u);
		Integer userId = u.getId();
		return chatService.showChatsByPaging(userId, pageNum, pageSize);
	}
	
	@PostMapping("/addChat.do")
	public GeneralResponse<Chat> addChat(String chatName, Integer[] userIds,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User u = (User) session.getAttribute("loginUser");
		System.out.println(u);
		Integer userId = u.getId();
		return chatService.addChat(chatName, userId, userIds);
	}
}
