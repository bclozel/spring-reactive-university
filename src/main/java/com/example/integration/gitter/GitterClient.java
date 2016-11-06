package com.example.integration.gitter;

import com.example.DashboardProperties;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Brian Clozel
 * @author Sebastien Deleuze
 */
@Component
public class GitterClient {

	private final WebClient webClient;

	public GitterClient(DashboardProperties properties) {
		this.webClient = WebClient.create()
				.filter(oAuthToken(properties.getGitter().getToken()));
	}

	public Flux<GitterUser> getUsersInRoom(String roomId, int limit) {
		return this.webClient
				.get().uri("https://api.gitter.im/v1/rooms/{roomId}/users?limit={limit}", roomId, limit)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.flatMap(response -> response.bodyToFlux(GitterUser.class));
	}

	public Mono<GitterUser> findUserInRoom(String userName, String roomId) {
		return this.webClient
				.get()
				.uri("https://api.gitter.im/v1/rooms/{roomId}/users?q={userName}", roomId, userName)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.then(response -> response.bodyToMono(GitterUser.class));
	}

	public Flux<GitterMessage> latestChatMessages(String roomId, int limit) {
		return this.webClient
				.get()
				.uri("https://api.gitter.im/v1/rooms/{roomId}/chatMessages?limit={limit}", roomId, limit)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.flatMap(response -> response.bodyToFlux(GitterMessage.class));
	}

	public Flux<GitterMessage> streamChatMessages(String roomId) {
		return this.webClient
				.get()
				.uri("https://stream.gitter.im/v1/rooms/{roomId}/chatMessages", roomId)
				.accept(MediaType.TEXT_EVENT_STREAM)
				.exchange()
				.flatMap(response -> response.bodyToFlux(GitterMessage.class));
	}

	private ExchangeFilterFunction oAuthToken(String token) {
		return (clientRequest, exchangeFunction) ->
				exchangeFunction
						.exchange(ClientRequest
								.from(clientRequest)
								.header("Authorization", "Bearer " + token)
								.build()
						);
	}
}
