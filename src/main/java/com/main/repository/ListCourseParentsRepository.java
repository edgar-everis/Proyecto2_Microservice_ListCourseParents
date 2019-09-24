package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.main.model.ListCourseParents;

import reactor.core.publisher.Flux;

@Repository
public interface ListCourseParentsRepository extends ReactiveMongoRepository<ListCourseParents, String> {

	Flux<ListCourseParents> findByIdstuteac(String idstuteac);
}
