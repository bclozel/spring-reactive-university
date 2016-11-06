package com.example.web;

import com.example.dashboard.DashboardService;
import com.example.dashboard.ReactorPerson;
import com.example.dashboard.ReactorPersonNotFoundException;
import com.example.dashboard.ReactorPersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Brian Clozel
 */
@Controller
public class DashboardController {

	private final DashboardService dashboardService;

	private final ReactorPersonRepository repository;

	@Autowired
	public DashboardController(DashboardService dashboardService, ReactorPersonRepository repository) {
		this.dashboardService = dashboardService;
		this.repository = repository;
	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/reactor/people")
	@ResponseBody
	public Flux<ReactorPerson> findReactorPeople() {
		return this.repository.findAll();
	}

	@GetMapping("/reactor/people/{id}")
	@ResponseBody
	public Mono<ReactorPerson> findReactorPerson(@PathVariable String id) {
		return this.repository.findOne(id)
				.otherwiseIfEmpty(Mono.error(new ReactorPersonNotFoundException(id)));
	}

	@ExceptionHandler
	public ResponseEntity handleNotFoundException(ReactorPersonNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/issues")
	public String issues(Model model) {
		model.addAttribute("issues", this.dashboardService.findReactorIssues());
		return "issues";
	}

}
