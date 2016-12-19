package ua.kiev.prog.repository;

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
//		if((list.size() != 0) && (m.getDate().getTime() - list.get(0).getDate().getTime()) > 5000)
//		{
//			list.remove(0);
//		}
		list.add(m);
	}
	
	public synchronized String toJSON(int n, String login) {
		if (n == list.size()) return null;
		return gson.toJson(new JsonMessages(list, n, login));
	}
}
