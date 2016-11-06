package com.example.integration.github;

import reactor.core.publisher.Flux;

import org.springframework.stereotype.Component;

/**
 * @author Brian Clozel
 */
@Component
public class GithubClient {

	public Flux<GithubIssue> findOpenIssues(String owner, String repo) {

		return Flux.empty();
	}

}
