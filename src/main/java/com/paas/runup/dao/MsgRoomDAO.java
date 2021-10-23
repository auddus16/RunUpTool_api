package com.paas.runup.dao;

import com.paas.runup.dto.MsgRoom;

public interface MsgRoomDAO {
	int insertMsgRoom(MsgRoom msgRoom);
	int deleteMsgRoom(String roomId);
	MsgRoom selectMsgRoomId(String roomId);
}
