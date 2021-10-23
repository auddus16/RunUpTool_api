package com.paas.runup.controller;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paas.runup.dto.MsgRoom;
import com.paas.runup.service.MsgService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@ServerEndpoint("/websocket")
public class MsgController extends Socket{
	
	private static final List<Session> session = new ArrayList<Session>();
	@Autowired
	private MsgService msgService;

	@PostMapping
	public MsgRoom createRoom(@RequestParam String name) {
		return msgService.createRoom(name);
	}

	@GetMapping
	public List<MsgRoom> findAllRoom() {
		return msgService.findAllRoom();
	}
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@OnOpen
    public void open(Session newUser) {
        System.out.println("connected");
        session.add(newUser);
        System.out.println(newUser.getId());
    }

    @OnMessage
    public void getMsg(Session recieveSession, String msg) {
        for (int i = 0; i < session.size(); i++) {
            if (!recieveSession.getId().equals(session.get(i).getId())) {
                try {
                    session.get(i).getBasicRemote().sendText("상대 : "+msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    session.get(i).getBasicRemote().sendText("나 : "+msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
