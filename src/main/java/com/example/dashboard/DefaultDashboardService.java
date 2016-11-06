package com.example.dashboard;

import java.util.List;
import java.util.Optional;

import com.example.DashboardProperties;
import com.example.integration.github.GithubClient;
import com.example.integration.github.GithubIssue;
import com.example.integration.gitter.GitterClient;
import com.example.integration.gitter.GitterMessage;
import com.example.integration.gitter.GitterUser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
		Flux<GithubIssue> issues = this.githubClient.findOpenIssues("reactor", "reactor-core");
		Mono<List<GitterUser>> users = this.gitterClient
				.getUsersInRoom(this.properties.getReactor().getGitterRoomId(), 300)
				.collectList();

		return users.flatMap(gitterUserList -> {
			return issues.map(issue -> {
				String userLogin = issue.getUser().getLogin();
				Optional<GitterUser> gitterUser = gitterUserList.stream()
						.filter(gu -> gu.getUsername().equals(userLogin)).findFirst();

				return new ReactorIssue(issue, gitterUser.isPresent());
			});
		});
	}

	@Override
	public Flux<GitterMessage> getLatestChatMessages(int limit) {
		return this.gitterClient
				.latestChatMessages(this.properties.getReactor().getGitterRoomId(), limit);
	}

	@Override
	public Flux<GitterMessage> streamChatMessages() {
		String roomId = this.properties.getReactor().getGitterRoomId();
		return this.gitterClient.streamChatMessages(roomId);
	}
}
