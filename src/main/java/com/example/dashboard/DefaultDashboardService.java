package com.example.dashboard;

import com.example.DashboardProperties;
import com.example.integration.github.GithubClient;
import com.example.integration.gitter.GitterClient;
import com.example.integration.gitter.GitterMessage;
import reactor.core.publisher.Flux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Brian Clozel
 */
@Service
public class DefaultDashboardService implements DashboardService {

	private final DashboardProperties properties;

	private final GitterClient gitterClient;

	private final GithubClient githubClient;

	@Autowired
	public DefaultDashboardService(DashboardProperties properties, GitterClient gitterClient, GithubClient githubClient) {
		this.properties = properties;
		this.gitterClient = gitterClient;
		this.githubClient = githubClient;
	}

	@Override
	public Flux<ReactorIssue> findReactorIssues() {
		return Flux.empty();
	}

	@Override
	public Flux<GitterMessage> getLatestChatMessages(int limit) {
		return Flux.empty();
	}

	@Override
	public Flux<GitterMessage> streamChatMessages() {
		return Flux.empty();
	}
}
