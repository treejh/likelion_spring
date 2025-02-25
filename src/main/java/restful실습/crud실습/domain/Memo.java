package restful실습.crud실습.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;


@Getter
@Setter
public class Memo {
    private Long id;
    private String content;
}
