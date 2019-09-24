package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import com.main.model.ListCourseParents;

import reactor.core.publisher.Flux;

public interface ListCourseParentsRepository extends ReactiveMongoRepository<ListCourseParents, String> {

	Flux<ListCourseParents> findByIdstuteach(String idstuteac);
}
