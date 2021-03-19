/**
 * 
 */
package org.spring.chat.bot.util;

/**
 * @author mahes
 *
 */
public final class ChatBotConstants {

	private ChatBotConstants() {}
	
	public static final String WEB_SOCKET_ENDPOINT_URL = "/websocket";
	public static final String WEB_SOCKET_APP_PATH_PREFIX = "/app";
	public static final String WEB_SOCKET_TOPIC_PATH_PREFIX = "/topic";
	public static final String WEB_SOCKET_CHAT_SEND_MSG_PATH = "/chat.sendMessage";
	public static final String WEB_SOCKET_CHAT_ADD_USR_PATH = "/chat.addUser";
	public static final String WEB_SOCKET_CHAT_RMV_USR_PATH = "/chat.removeUser";
	public static final String WEB_SOCKET_TOPIC_PATH = "/topic/public";
	public static final String WEB_SOCKET_HDR_USER_KEY = "username";
}
