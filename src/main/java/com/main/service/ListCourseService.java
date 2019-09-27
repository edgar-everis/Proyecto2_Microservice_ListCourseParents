package com.main.service;

import com.main.model.ListCourseParents;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ListCourseService {

  Mono <ListCourseParents> CreateListCourseParents(ListCourseParents listcourseparents);

  Mono <Void> DeleteById(String id);

  Mono <ListCourseParents> findById(String id);

  Flux<ListCourseParents> findByIdstuteac(String idstuteac);

  Flux<ListCourseParents> GetAll();

  Mono<ListCourseParents> ModifyListSCourseParents(String id, ListCourseParents listcourseparents);
}
