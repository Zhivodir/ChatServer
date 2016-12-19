package ua.kiev.prog.repository;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.JsonMessages;
import ua.kiev.prog.model.Message;

public class MessageList {
	private static final MessageList msgList = new MessageList();

    private final Gson gson;
	private final List<Message> list = new LinkedList<Message>();
	
	public static MessageList getInstance() {
		return msgList;
	}
  
  	private MessageList() {
		gson = new GsonBuilder().create();
	}
	
	public synchronized void add(Message m) {
		if(list.size() != 0) {
			long currentTime = new Date().getTime();
			long oldestMessage = list.get(0).getDate().getTime();
			if ((currentTime - oldestMessage) > 10000) {
				list.remove(0);
//				for (Message message : msgList.getList()) {
//					if (currentTime - message.getDate().getTime() > 10000) {
//						msgList.getList().remove(message);
//					}
//				}
			}
		}
		list.add(m);
	}

	public List<Message> getList(){
		return list;
	}

	public synchronized String toJSON(int n, String login) {
		if (n == list.size()) return null;
		return gson.toJson(new JsonMessages(list, n, login));
	}
}
