package restful실습.event실습.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restful실습.event실습.domain.Event;
import restful실습.event실습.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    @Transactional
    public Event addEvent(Event event){

        if(event.getDescription().isEmpty() || event.getTitle().isEmpty()){
            throw  new RuntimeException("올바른 값을 입력해주세요");
        }

        return eventRepository.save(event);

    }

    @Transactional
    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    @Transactional
    public Event getEvent(Long id){
        return eventRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("event가 없습니다 : "+id));
    }

    @Transactional
    public Event updateEvent(Long id, Event event){
        if(event.getDescription().isEmpty() || event.getTitle().isEmpty()){
            throw  new RuntimeException("올바른 값을 입력해주세요");
        }
        Event updateEvent = eventRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("수정할 event가 없습니다 : "+id));

        updateEvent.setDescription(event.getDescription());
        updateEvent.setTitle(event.getTitle());

        return updateEvent;

    }

    @Transactional
    public String deleteEvent(Long id){
        eventRepository.deleteById(id);

        return "event 삭제가 완료되었습니다. ";
    }



}
