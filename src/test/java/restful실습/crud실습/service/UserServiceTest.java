package restful실습.crud실습.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import restful실습.crud실습.domain.User;
import restful실습.기본개념실습.UserRepository;


@SpringBootTest
@Transactional //테스트가 끝나면 DB 변경했던 사항들을 rollback 시켜준다.
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원가입 - 성공")
    void register_success() {
        User user = new User();
        user.setName("testCase");
        user.setEmail("testCase@email.com");
        String response = userService.addUser22(user);

        assertEquals("회원가입 성공!!",response);
        assertTrue(userRepository.findByEmailAndName(user.getEmail(),user.getName()).isPresent());
    }

    @Test
    @DisplayName("회원가입 - 이메일 중복 실행")
    void register_EmailFail(){
        String email = "test@example.com";
        String name = "testCase";

        //기존 사용자 저장
        User existingUser = new User();
        existingUser.setEmail(email);
        existingUser.setName(name);
        userRepository.save(existingUser);


        //동일한 이메일로 회원가입 테스트
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        String response = userService.addUser22(newUser);
        assertEquals("이미 존재하는 아이디입니다.",response);


    }




}