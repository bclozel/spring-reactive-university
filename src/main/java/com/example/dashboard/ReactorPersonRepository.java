package com.example.dashboard;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * @author Brian Clozel
 */
public interface ReactorPersonRepository extends ReactiveCrudRepository<ReactorPerson, String> {

}
