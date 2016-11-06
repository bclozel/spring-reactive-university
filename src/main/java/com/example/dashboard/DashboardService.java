package com.example.dashboard;

import com.example.integration.gitter.GitterMessage;
import reactor.core.publisher.Flux;

/**
 * @author Brian Clozel
 */
public interface DashboardService {

	Flux<ReactorIssue> findReactorIssues();

	Flux<GitterMessage> getLatestChatMessages(int limit);

	Flux<GitterMessage> streamChatMessages();
}
