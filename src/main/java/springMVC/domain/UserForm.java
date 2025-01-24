package springMVC.domain;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserForm {
    @NotEmpty(message = "username은 공백을 허용하지 않습니다.")
    @Pattern(
            regexp = ".[!@#$%^&(),.?\":{}|<>].*",
            message = "비밀번호는 최소 하나의 특수문자를 포함해야 합니다."
    )
    String userName;

    @NotEmpty(message = "password는 공백을 허용하지 않습니다.")
    String passWord;

}
