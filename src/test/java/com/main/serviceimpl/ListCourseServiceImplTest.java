package com.main.serviceimpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.main.model.ListCourseParents;

import com.main.repository.ListCourseParentsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ListCourseServiceImplTest {

    @Mock
    private ListCourseParentsRepository repo;
    
    @InjectMocks
    private ListCourseServiceImpl service;
    
  @Test
  public void testCreateListCourseParents() {
   
      
      ListCourseParents list = new ListCourseParents();
      list.setId("2");
      list.setIdcourse("C01");
      list.setIdparent("P01");
      list.setIdstuteac("STU01");
     
      when(repo.save(list)).thenReturn(Mono.just(list));
      Mono<ListCourseParents> actual = service.CreateListCourseParents(list);
      assertResults(actual, list);
  }

  @Test
  public void testDeleteById() {
     
      ListCourseParents list = new ListCourseParents();
      list.setId("1");
      list.setIdcourse("C01");
      list.setIdparent("P01");
      list.setIdstuteac("STU01");
      when(repo.delete(list)).thenReturn(Mono.empty());
  }

  @Test
  public void testFindById() {
     
      ListCourseParents list = new ListCourseParents();
      list.setId("1");
      list.setIdcourse("C01");
      list.setIdparent("P01");
      list.setIdstuteac("STU01");

      when(repo.findById("2")).thenReturn(Mono.just(list));
      Mono<ListCourseParents> actual = service.findById("2");
      assertResults(actual, list);
      System.out.println(actual);
     
  }

  @Test
  public void testFindByIdstuteac() {
      ListCourseParents list = new ListCourseParents();
      list.setId("1");
      list.setIdcourse("C01");
      list.setIdparent("P01");
      list.setIdstuteac("STU01");

      when(repo.findByIdstuteac("STU01")).thenReturn(Flux.just(list));
      Flux <ListCourseParents> actual = service.findByIdstuteac("STU01");
      assertResults(actual, list);
      System.out.println(actual);
  }

  @Test
  public void testGetAll() {
     
      ListCourseParents list = new ListCourseParents();
      list.setId("1");
      list.setIdcourse("C01");
      list.setIdparent("P01");
      list.setIdstuteac("STU01");
      when(service.GetAll()).thenReturn(Flux.just(list));
      Flux<ListCourseParents> actual = service.GetAll();
      assertResults(actual,list);
  }
  private void assertResults(Publisher<ListCourseParents> publisher, ListCourseParents... expectedProducts) {
      StepVerifier
          .create(publisher)
          .expectNext(expectedProducts)
          .verifyComplete();

}
}
