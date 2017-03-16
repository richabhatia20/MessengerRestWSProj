package org.richa.jerseyprac.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.richa.jerseyprac.messenger.model.Message;
import org.richa.jerseyprac.messenger.service.MessageService;

@Path("messages")
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,
			@QueryParam("start") int start,
			@QueryParam("size") int size)
	{
		if(year > 0)
		{
			return messageService.getAllMessagesForYear(year);
		}
		
		if(start >= 0 && size >= 0)
		{
			return messageService.getAllMessagesPaginated(start, size);
			
		}
		
		return messageService.getAllMessages();
		
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test()
	{
		
	return "test";
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo)
	{
		Message message =messageService.getMessage(messageId);
		
		String uri = getUriForSelf(uriInfo, message); 
		
		message.addLink(uri, "self");
		return message;
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()     //this gives http://localhost:8080/messenger/webapi
		.path(MessageResource.class)                 //this gives /messages
		.path(Long.toString(message.getId()))
		.build()
		.toString();
		return uri;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message m)
	{
		return messageService.addMessage(m);
		
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long messageId, Message message)
	{
		message.setId(messageId);
	return messageService.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long messageId)
	{
		
	 messageService.removeMessage(messageId);
	}
}
