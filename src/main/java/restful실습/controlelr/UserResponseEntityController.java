package restful실습.controlelr;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import restful실습.domain.User;

public class UserResponseEntityController {
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody User user){
        Long id = counter.incrementAndGet();
        user.setId(id);
        users.put(id,user);
        return ResponseEntity.status(200).body(id);
    }

    @GetMapping
    public ResponseEntity<Map<Long,User>> getUsers(){
        return ResponseEntity.ok(users);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id ){
        User user = users.get(id);
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }


    @PutMapping
    public ResponseEntity<User> updateMemo(@PathVariable("id") Long id, @RequestBody User user){
        if(!users.containsKey(id)){
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        users.put(id,user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable("id") Long id){
        if(!users.containsKey(id)){
            return ResponseEntity.status(404).body("해당 유저를 찾을 수 없습니다 ");
        }
        users.remove(id);
        return ResponseEntity.ok("유저 삭제 성공");

    }
}
