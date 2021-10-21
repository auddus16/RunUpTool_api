package com.paas.runup.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paas.runup.dto.MsgRoom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MsgService {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Map<String, MsgRoom> msgRooms;
	
	@PostConstruct
	private void init() {
		System.out.println("init 실행됨ㅁㅁ");
		msgRooms = new LinkedHashMap<>();
	}
	
	public List<MsgRoom> findAllRoom(){
		System.out.println("findAllRoom실행됨");
		System.out.println(msgRooms.values());
		return new ArrayList<>(msgRooms.values());
	}
	
	public MsgRoom findbyId(String roomId) {
		System.out.println("findbyId 실행됨"+roomId);
		return msgRooms.get(roomId);
	}
	
	public MsgRoom createRoom(String name) {
		String roomId= name;
		System.out.println(roomId);
		
		MsgRoom msgRoom = new MsgRoom(roomId);
		msgRooms.put(roomId, msgRoom);
		
		return msgRoom;
		//return MsgRoom.builder().roomId(roomId).build();
	}
	
	public <T> void sendMessage(WebSocketSession session, T message) {
		try {
			session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
