package com.xdd.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdd.common.GeneralResponse;
import com.xdd.entity.User;
import com.xdd.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class); 
	
	@Resource
	private IUserService userService;

	@PostMapping("/deleteByPrimaryKey.do")
	public int deleteByPrimaryKey(int id, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		int i = userService.deleteByPrimaryKey(id);
		return i;
	}

	@PostMapping("/insert.do")
	public int insert(User record, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int i = userService.insert(record);
		return i;
	}

	@PostMapping("/insertSelective.do")
	public int insertSelective(User record, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		int i = userService.insertSelective(record);
		return i;
	}

	@RequestMapping("/selectByPrimaryKey.do")
	public User selectByPrimaryKey(int id, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		User u = userService.selectByPrimaryKey(id);
		return u;
	}

	@PostMapping("/updateByPrimaryKeySelective.do")
	public int updateByPrimaryKeySelective(User record, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		int i = userService.updateByPrimaryKeySelective(record);
		return i;
	}

	@PostMapping("/updateByPrimaryKey.do")
	public int updateByPrimaryKey(User record, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		int i = userService.updateByPrimaryKey(record);
		return i;
	}

	@RequestMapping("/getUsers.do")
	public List<User> getUsers(String startTime, String endTime, User user, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		List<User> u = userService.getUsers(startTime, endTime, user);
		return u;
	}

	@GetMapping("/findByPage.do")
	public GeneralResponse<List<User>> findByPaging(String startTime, String endTime, String username, Integer pageNum,
			Integer pageSize, HttpServletRequest request, HttpServletResponse response,	HttpSession session) {
		return userService.findByPaging(startTime, endTime, username, pageNum, pageSize);
	}

	@RequestMapping("/getUser.do")
	public User getUser(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User u = userService.getUser(user);
		return u;
	}

	@RequestMapping("/login.do")
	public Map<String, Object> login(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		User u = userService.getUser(user);
		System.out.println(u);
		logger.info("u{}="+u);
		logger.debug("u debug{}="+u);
		logger.error("u error{}="+u);
		Map<String, Object> map = new HashMap<String, Object>();
		if(u != null) {
			request.getSession().setAttribute("loginUser", u);
			map.put("code", 1);
			map.put("message", "登录成功");
			map.put("data", u);
		} else {
			map.put("code", 0);
			map.put("message", "密码或者用户名错误");
			map.put("data", null);
		}
		return map;
	}	
	
	@RequestMapping("/logout.do")
	public Map<String, Object> logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		request.getSession().removeAttribute("loginUser");
		map.put("code", 1);
		map.put("message", "退出成功");
		map.put("data", null);
		return map;
	}
}
