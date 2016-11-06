package com.example.integration.github;

import com.example.DashboardProperties;
import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Brian Clozel
 * @author Sebastien Deleuze
 */
@Component
public class GithubClient {

	private static final MediaType VND_GITHUB_V3 = MediaType.valueOf("application/vnd.github.v3+json");

	private final WebClient webClient;

	public GithubClient(DashboardProperties properties) {
		this.webClient = WebClient
				.create("https://api.github.com")
				.filter(ExchangeFilterFunctions
						.basicAuthentication(properties.getGithub().getUsername(),
								properties.getGithub().getToken()))
				.filter(userAgent());
	}

	public Flux<GithubIssue> findOpenIssues(String owner, String repo) {
		return this.webClient
				.get()
				.uri("/repos/{owner}/{repo}/issues?state=open", owner, repo)
				.accept(VND_GITHUB_V3)
				.exchange().flatMap(response -> response.bodyToFlux(GithubIssue.class));
	}


	private ExchangeFilterFunction userAgent() {
		return (clientRequest, exchangeFunction) -> {
			ClientRequest newRequest = ClientRequest
					.from(clientRequest)
					.header("User-Agent", "Spring Framework WebClient")
					.build();
			return exchangeFunction.exchange(newRequest);
		};
	}

}
