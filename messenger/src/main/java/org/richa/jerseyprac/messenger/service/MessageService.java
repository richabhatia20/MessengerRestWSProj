package org.richa.jerseyprac.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.richa.jerseyprac.messenger.database.DatabaseClass;
import org.richa.jerseyprac.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	
	public List<Message> getAllMessages()
	{
		Message m1 = new Message(1L, "Hello World", "Richa");
		Message m2 = new Message(2L, "Hello Jersey", "Richa");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
		
		
	}
	
	public Message getMessage(long id)
	{
		
		return null;
	}
	
	public Message addMessage()
	{
		
		return null;
	}
	
	public Message updateMessage()
	{
		
		return null;
	}
	
	public Message removeMessage()
	{
		
		return null;
	}
}
