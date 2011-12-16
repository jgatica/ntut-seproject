package com.projectplus.msgpasser;

/**
 * 這個類別用來負責消息系統的新增消息
 * @author Augus
 *
 */
public class MessagePasser {

	// 各類訊息編號參考MessageType的Class
	
	static public boolean passTeamMessage(int messageType){
		if (messageType == MessageType.TEAM_MEMBER_JOIN) {
		}
		return true;
	}
	
	
}
