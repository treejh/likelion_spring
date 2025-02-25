package restful실습.event실습.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restful실습.event실습.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;


}
