package org.spring.chat.bot.controller;
import org.spring.chat.bot.model.ChatMessage;
import org.spring.chat.bot.util.ChatBotConstants;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @MessageMapping(ChatBotConstants.WEB_SOCKET_CHAT_SEND_MSG_PATH)
    @SendTo(ChatBotConstants.WEB_SOCKET_TOPIC_PATH)
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping(ChatBotConstants.WEB_SOCKET_CHAT_ADD_USR_PATH)
    @SendTo(ChatBotConstants.WEB_SOCKET_TOPIC_PATH)
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put(ChatBotConstants.WEB_SOCKET_HDR_USER_KEY, chatMessage.getSender());
        return chatMessage;
    }
    
    @MessageMapping(ChatBotConstants.WEB_SOCKET_CHAT_RMV_USR_PATH)
    @SendTo(ChatBotConstants.WEB_SOCKET_TOPIC_PATH)
    public ChatMessage removeUser(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

}