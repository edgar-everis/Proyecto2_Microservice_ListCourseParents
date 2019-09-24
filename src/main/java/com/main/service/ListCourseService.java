package com.main.service;

import com.main.model.ListCourseParents;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ListCourseService {

	    Flux<ListCourseParents> findByIdstuteac(String idstuteac);
	
	    Flux<ListCourseParents> GetAll();

	    Mono<ListCourseParents> findById(String id);

	    Mono<ListCourseParents> CreateListSCourseParents(ListCourseParents listcourseparents);

	    Mono<ListCourseParents> ModifyListSCourseParents(String id, ListCourseParents listcourseparents);

	    Mono<Void> DeleteById(String id);
}
