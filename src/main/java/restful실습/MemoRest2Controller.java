package restful실습;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restful실습.domain.Memo;

@RestController
@RequestMapping("/api4/memos")
public class MemoRest2Controller {
    //private final Map<Long, String> memos = new HashMap<>();
    private final Map<Long, Memo> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();
    //string
//curl -X POST "Content-type: text/plain" -d "첫번째 메모" http://localhost:8080/api2/memos
//    @PostMapping
//    public Long createMemo(@RequestBody String content){
//        Long id = counter.incrementAndGet();
//        memos.put(id,content);
//        return id;
//    }
    //json
//curl -X POST -H "Content-type: application/json" -d "{\"content\":\"첫번째 메모\"}"  http://localhost:8080/api3/memos
//http://localhost:8080/api3/memos      --  POST     저장 (C)
//    @PostMapping
//    public Long createMemo(@RequestBody Memo memo){
//        Long id = counter.incrementAndGet();
//        memo.setId(id);
//        memos.put(id,memo);
//        return id;
//    }

    //responseEntity
    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody Memo memo){
        Long id = counter.incrementAndGet();
        memo.setId(id);
        memos.put(id,memo);
        return ResponseEntity.status(200).body(id);
    }

//    //curl -X GET http://localhost:8080/api3/memos
//    //http://localhost:8080/api3/memos
//    @GetMapping
//    public Map<Long,Memo> getMemos(){
//        return memos;
//    }

    //responseEntity 사용
    @GetMapping
    public ResponseEntity<Map<Long,Memo>> getMemos(){
        return ResponseEntity.ok(memos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Memo> getMemo(@PathVariable("id") Long id){
        Memo memo = memos.get(id);
        if(memo ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memo);
    }

//json
    //curl -X PUT -H "Content-type: application/json" -d "{\"content\":\"수정된 메모\"}" http://localhost:8080/api3/memos/1
    //http://localhost:8080/api3/memos/1
//    @PutMapping("/{id}")
//    public String updateMemo(@PathVariable("id") Long id, @RequestBody Memo memo){
//
//        if(memos.containsKey(id)){
//            memos.put(id,memo);
//            return "메모 수정 성공";
//        }else{
//            return "수정할 메모가 없습니다. ";
//        }
//    }
//

    //responseEntity

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMemo(@PathVariable("id") Long id, @RequestBody Memo memo){

        if(!memos.containsKey(id)){
            return ResponseEntity.status(400).body("해당 메모를 찾을 수 없어요 ");
        }
        memo.setId(id);
        memos.put(id,memo);
        return ResponseEntity.ok("메모 수정 성공");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable("id") Long id){
        if(!memos.containsKey(id)){
            return ResponseEntity.status(404).body("해당 메모를 찾을 수 없어요 ");
        }
       memos.remove(id);
        return ResponseEntity.ok("메모 삭제 성공");

    }


}
