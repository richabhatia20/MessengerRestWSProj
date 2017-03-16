package org.richa.jerseyprac.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
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
	
	
	public List<Message> getAllMessagesForYear(int year)
	{
		
		List<Message> messagesForYear = new ArrayList<>();
		
		Calendar cal = Calendar.getInstance();
		
		for(Message message :messages.values())
		{
			
			cal.setTime(message.getCreated());
			
			if(cal.get(Calendar.YEAR)== year){
				messagesForYear.add(message);
				
			}
		}
		
		return messagesForYear;
		
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size)
	{
		
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		
		if(start+ size > list.size())
		{
			return new ArrayList<Message>();
		}
		
		return list.subList(start, start+size);
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
	
	public Message updateMessage(Message message)
	{
		if(message.getId() <= 0)
		{
			
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id)
	{
		
		return messages.remove(id);
	}
}
