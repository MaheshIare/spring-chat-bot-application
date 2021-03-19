package org.spring.chat.bot.config;

import org.spring.chat.bot.util.ChatBotConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Value("${relay.broker.host}")
	private String relayHost;

	@Value("${relay.broker.port}")
	private Integer relayPort;

	@Value("${relay.broker.username}")
	private String relayUsername;

	@Value("${relay.broker.passcode}")
	private String relayPasscode;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint(ChatBotConstants.WEB_SOCKET_ENDPOINT_URL).withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes(ChatBotConstants.WEB_SOCKET_APP_PATH_PREFIX);
		//TODO: To enable simple inmemory message broker
		registry.enableSimpleBroker(ChatBotConstants.WEB_SOCKET_TOPIC_PATH_PREFIX);
		
		//TODO: Use this for enabling a Full featured broker like RabbitMQ/ActiveMQ
        //registry.enableStompBrokerRelay(ChatBotConstants.WEB_SOCKET_TOPIC_PATH_PREFIX)
        //        .setRelayHost(relayHost)
        //        .setRelayPort(relayPort)
        //        .setClientLogin(relayUsername)
        //        .setClientPasscode(relayPasscode);
	}
}