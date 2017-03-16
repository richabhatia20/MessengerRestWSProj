package org.richa.jerseyprac.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.richa.jerseyprac.messenger.database.DatabaseClass;
import org.richa.jerseyprac.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService()
	{
		messages.put(1L, new Message(1L, "Hello World", "Richa"));
		messages.put(2L, new Message(2L, "Hello Jersey", "Richa"));
		
	}
	
	
	public List<Message> getAllMessages()
	{
//		Message m1 = new Message(1L, "Hello World", "Richa");
//		Message m2 = new Message(2L, "Hello Jersey", "Richa");
//		List<Message> list = new ArrayList<>();
//		list.add(m1);
//		list.add(m2);
//		return list;
//		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id)
	{
		
		return messages.get(id);
	}
	
	public Message addMessage(Message m)
	{
		m.setId(messages.size()+1);
		messages.put(m.getId(), m);
		return m;
	}
	
	public Message updateMessage(Message m)
	{
		if(m.getId() <= 0)
		{
			
			return null;
		}
		messages.put(m.getId(), m);
		return m;
	}
	
	public Message removeMessage(long id)
	{
		
		return messages.remove(id);
	}
}
