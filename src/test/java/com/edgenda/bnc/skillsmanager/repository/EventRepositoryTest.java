package com.edgenda.bnc.skillsmanager.repository;

import com.edgenda.bnc.skillsmanager.model.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {

  @Autowired
  private EventRepository eventRepository;

  @Test
  public void testFindById() {
    Optional<Event> event = eventRepository.findById(1L);
    int n = 0;
  }


  @Test
  public void testFindBetweenDate() {

  /*  LocalDateTime from = LocalDateTime.of(2012, 9, 01, 00, 00);
    LocalDateTime to = LocalDateTime.of(2012, 10, 01, 00, 00);

    List<Event> events = eventRepository.findByPeriod(from,to);

    assertEquals(1, events.size());*/


  }

}
