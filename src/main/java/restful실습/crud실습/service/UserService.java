package restful실습.crud실습.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restful실습.기본개념실습.UserRepository;
import restful실습.crud실습.domain.User;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User findById(Long id){
        return repository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<User> getUsers(){

        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public User getUser(Long id){

        return repository.findById(id)
                .orElseThrow(() ->new RuntimeException("id에 해당하는 사용자를 찾을 수 없어요. id::"+id));
    }

    @Transactional
    public User addUser(User user){
        try {
            return repository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("사용자 추가 실패 :: "+e.getMessage(), e);
        }
    }

    @Transactional
    public String addUser22(User user){
        try {
            if(repository.findByEmailAndName(user.getEmail(),user.getName()).isPresent()){
                return "이미 존재하는 아이디입니다.";
            }
            repository.save(user);
            return "회원가입 성공!!";
        } catch (Exception e) {
            throw new RuntimeException("사용자 추가 실패 :: "+e.getMessage(), e);
        }
    }

    @Transactional
    public User updateUser(User user){
        if(user.getId() == null){
            throw new IllegalArgumentException("사용자 ID는 필수입니다.");
        }

        User findUser = repository.findById(user.getId()).orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없어요." + user.getId()));

        //user의 필드가 null이 아닌 것만 update
        if(user.getName() != null) findUser.setName(user.getName());
        if(user.getEmail() != null) findUser.setEmail(user.getEmail());
        return findUser;    //커밋될때..  findUser의 변경감지로 자동 업데이트 진행될 것임.
        // save() 를 호출하는것보다는 변경감지해서 수정하도록 하는것이 좋다.
    }

    @Transactional
    public void deleteUser(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("ID에 맞는 사용자를 찾을 수 없어요. ID :: "+id);
        }
        repository.deleteById(id);
    }
}
