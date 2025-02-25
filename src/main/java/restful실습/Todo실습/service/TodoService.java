package restful실습.Todo실습.service;


import jakarta.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restful실습.Todo실습.domain.Todo;
import restful실습.Todo실습.repostiroy.TodoRepository;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public Todo createTodo(Todo todo){
        try {
            return todoRepository.save(todo);
        }catch (Exception e){
            throw new RuntimeException("todo 추가 실패" + e.getMessage());
        }
    }

    @Transactional
    public List<Todo> getTodos(){
       return todoRepository.findAll(Sort.by("id").descending());
    }


    public Todo updateTodo(Long id){
        Todo updateTodo = todoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Todo를 찾을 수 없습니다 "+ id));

//        if(updateTodo.isDone()==true){
//            updateTodo.setDone(false);
//        }else{
//            updateTodo.setDone(true);
//        }
        updateTodo.setDone(!updateTodo.isDone());

        return todoRepository.save(updateTodo);

    }

    public void deleteTodo(Long id){
        Todo deleteTodo = todoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Todo를 찾을 수 없습니다 "+ id));
        todoRepository.delete(deleteTodo);
    }




}
