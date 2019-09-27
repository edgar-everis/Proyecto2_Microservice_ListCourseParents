package com.main.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.ListCourseParents;
import com.main.repository.ListCourseParentsRepository;
import com.main.service.ListCourseService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ListCourseServiceImpl implements ListCourseService {

  @Autowired private ListCourseParentsRepository repository;

  @Override
  public Mono<ListCourseParents> CreateListCourseParents(ListCourseParents listcourseparents) {
    // TODO Auto-generated method stub
    return repository.save(listcourseparents);
  }

  @Override
  public Mono<Void> DeleteById(String id) {
    // TODO Auto-generated method stub
    return repository.deleteById(id);
  }

  @Override
  public Mono<ListCourseParents> findById(String id) {

    return repository.findById(id);
  }

  @Override
  public Flux<ListCourseParents> findByIdstuteac(String idstuteac) {

    return repository.findByIdstuteac(idstuteac);
  }

  @Override
  public Flux<ListCourseParents> GetAll() {

    return repository.findAll();
  }

  @Override
  public Mono<ListCourseParents> ModifyListSCourseParents(
      String id, ListCourseParents listcourseparents) {
    // TODO Auto-generated method stub
    listcourseparents.setId(id);
    return repository.save(listcourseparents);
  }
}
