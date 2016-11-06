package com.example.web;

import com.example.dashboard.DashboardService;
import com.example.dashboard.ReactorPersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

}
