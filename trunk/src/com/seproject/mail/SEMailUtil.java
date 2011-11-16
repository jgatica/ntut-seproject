package com.seproject.mail;

import java.util.ArrayList;

public class SEMailUtil {
	
	private static MailSystem mailSystem = null;
	private static String ACCOUNT = "augus790302@gmail.com";
	private static String PASSWORD = "a0911061317";
	
	static{
		mailSystem = new MailSystem(ACCOUNT, PASSWORD);
	}
	
	/**
	 * 傳送訊息給一組人
	 * @param receivers 存放群組的字串陣列
	 * @return 成功 :true 失敗 :false
	 * @throws Exception
	 */
	static public boolean sendMail(String[] receivers, String subjec, String content) {
		
		mailSystem.setTo(receivers);
		mailSystem.setFrom("augus790302@gmail.com");
		mailSystem.setSubject(subjec);
		mailSystem.setBody(content);
		
		try {
			mailSystem.send();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	/**
	 * 傳送訊息給一組人
	 * @param receivers 存放群組的字串陣列
	 * @return 成功 :true 失敗 :false
	 * @throws Exception
	 */
	static public boolean sendMail(ArrayList<String> receivers, String subjec, String content) {
		
		return sendMail(receivers.toArray(new String[receivers.size()]), subjec, content);
		
	}	
	
	
	/**
	 * 傳送Mail給一個人
	 * @param receiver 接收者
	 * @return 成功 :true 失敗 :false
	 * @throws Exception
	 */
	static public boolean sendMail(String receiver, String subjec, String content) {
		return sendMail(new String[]{receiver}, subjec, content);
	}
	
	public static void main(String[] args) {
		ArrayList<String> receivers = new ArrayList<String>(){{
			add("augus19900302@yahoo.com.tw");
			add("790302@gmail.com");
		}};
		sendMail("augus790302@gmail.com", "hello2", "Test content");
	}
	
}
