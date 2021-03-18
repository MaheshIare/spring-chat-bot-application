package org.spring.chat.bot.model;


import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
	
	private MessageType messageType;
	private String content;
	private String sender;

	
	
	/**
	 * @return the messageType
	 */
	public MessageType getMessageType() {
		return messageType;
	}



	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}



	/**
	 * @return the content
	 */
	public String getContent() {
		return StringUtils.isEmpty(content) ? StringUtils.EMPTY : content;
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