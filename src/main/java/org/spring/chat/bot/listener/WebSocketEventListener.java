package org.spring.chat.bot.listener;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.chat.bot.model.ChatMessage;
import org.spring.chat.bot.util.ChatBotConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		logger.info("Received a new web socket connection");
	}

	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String username = (String) headerAccessor.getSessionAttributes().get(ChatBotConstants.WEB_SOCKET_HDR_USER_KEY);
		if (StringUtils.isNotBlank(username)) {
			logger.info("{} got disconnected from chat at: {}", username, new Date(event.getTimestamp()));
			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setType(ChatMessage.MessageType.LEAVE);
			chatMessage.setSender(username);
			chatMessage.setContent(username +" left!");
			messagingTemplate.convertAndSendToUser(username, ChatBotConstants.WEB_SOCKET_TOPIC_PATH, chatMessage);
		} else {
			logger.warn("Something went wrong while disconnecting the user from chat");
		}
	}
}