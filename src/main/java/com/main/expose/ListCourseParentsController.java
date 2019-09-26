package com.main.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.ListCourseParents;
import com.main.service.ListCourseService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/API/ListCourseParents")
public class ListCourseParentsController {

  @Autowired private ListCourseService service;

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<ListCourseParents> createListCourseParents(
      @RequestBody ListCourseParents listcourseparents) {
    return service.CreateListSCourseParents(listcourseparents);
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteListCourseParents(@PathVariable String id) {
    return service.DeleteById(id);
  }

  @GetMapping("/find/{idstuteac}")
  public Flux<ListCourseParents> FindbyIdstuteac(@PathVariable String idstuteac) {
    return service.findByIdstuteac(idstuteac);
  }

  @GetMapping
  public Flux<ListCourseParents> Getall() {
    return service.GetAll();
  }

  @PutMapping("/update/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<ListCourseParents> updateListCourseParents(
      @PathVariable String id, @RequestBody ListCourseParents listcourseparents) {
    return service.ModifyListSCourseParents(id, listcourseparents);
  }
}
