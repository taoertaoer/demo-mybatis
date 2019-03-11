package com.xdd.util;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint("/webSocket/chat/{roomId}")
@Component
public class WsServer {

	private static final Map<Integer, Set<Session>> rooms = new ConcurrentHashMap<Integer, Set<Session>>();

	@OnOpen
	public void connect(@PathParam("roomId") Integer roomId, Session session) throws Exception {
		// 将session按照房间来存储，将各个房间的用户隔离
		if (!rooms.containsKey(roomId)) {
			// 创建房间不存在时，创建房间
			Set<Session> room = new HashSet<>();
			// 添加用户
			room.add(session);
			rooms.put(roomId, room);
		} else {
			// 房间已存在，直接添加用户到相应的房间
			rooms.get(roomId).add(session);
		}
		System.out.println("a client has connected!");
	}

	@OnClose
	public void disConnect(@PathParam("roomId") Integer roomId, Session session) {
		rooms.get(roomId).remove(session);
		System.out.println("a client has disconnected!");
	}

	@OnMessage
	public void receiveMsg(@PathParam("roomId") Integer roomId, String msg, Session session) throws Exception {
		// 此处应该有html过滤
		msg = session.getId() + ":" + msg;
		System.out.println(msg);
		// 接收到信息后进行广播
		broadcast(roomId, msg);
	}

	// 按照房间名进行广播
	public static void broadcast(Integer roomId, String msg) throws Exception {
		for (Session session : rooms.get(roomId)) {
			session.getBasicRemote().sendText(msg);
		}
	}

}