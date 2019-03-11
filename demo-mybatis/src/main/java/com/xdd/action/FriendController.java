package com.xdd.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdd.common.GeneralResponse;
import com.xdd.entity.Friend;
import com.xdd.entity.User;
import com.xdd.service.IFriendService;

@RestController
@RequestMapping("/friend")
public class FriendController {

	@Resource
	private IFriendService friendService;

	@GetMapping("/showFriendsByPaging.do")
	public GeneralResponse<List<Friend>> showFriendsByPaging(Integer pageNum, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User u = (User) session.getAttribute("loginUser");
		System.out.println(u);
		Integer userId = u.getId();
		return friendService.showFriendsByPaging(userId, pageNum, pageSize);
	}

	@PostMapping("/addFriend.do")
	public GeneralResponse<User> addFriend(Friend friend,HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		User u = (User) session.getAttribute("loginUser");
		System.out.println(u);
		friend.setCreateTime(new Date());
		friend.setCreaterId(u.getId());
		friend.setIsValid(1);
		return friendService.addFriend(friend);
	}
}
