package org.spring.chat.bot.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
	
	private MessageType type;
	private String content;
	private String sender;

	
	
	/**
	 * @return the messageType
	 */
	public MessageType getType() {
		return type;
	}



	/**
	 * @param messageType the messageType to set
	 */
	public void setType(MessageType type) {
		this.type = type;
	}



	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}



	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}



	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}



	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}



	public enum MessageType {
		CHAT, JOIN, LEAVE
	}

}