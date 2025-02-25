package restful실습.FileUpload실습.controller;


import jakarta.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class FileController {

    //파일 다운로드(서버에 사진 내놔라 요청,게시글에서 사진 보여줄때 그거 ㅇㅇ  )
    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response){
        Path path = Paths.get("/Users/jangjihyeon/Desktop/testtest/cat.jpeg");

        //응답을 image로 설정
        response.setContentType("image/jpeg");

        //사진을 inputStream형태로 바꿔준다.
        //파일 입출력은 try
        try(InputStream inputStream = Files.newInputStream(path)){

            //spring -> StreamUtils제공
            StreamUtils.copy(inputStream,response.getOutputStream());
            response.flushBuffer();
        }catch (IOException e){
            log.error("파일 다운로드 중 오류 발생  : " + e.getMessage());
        }

    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file
            //@RequestParam(name="info",required = false) UploadInfo uploadInfo
    ){

        log.info(file.getOriginalFilename());

        try(InputStream inputStream = file.getInputStream()){
//            StreamUtils.copy(inputStream,
//                    new FileOutputStream(("/Users/jangjihyeon/Desktop/정처기/")+file.getOriginalFilename()));
            StreamUtils.copy(inputStream,
                    new FileOutputStream("/Users/jangjihyeon/Desktop/tesTest/"+ UUID.randomUUID().toString() +file.getOriginalFilename()));
            return ResponseEntity.ok().body("파일 저장 성공!" + file.getOriginalFilename());

        }catch (IOException e){
            return ResponseEntity
                    .badRequest()
                    .body("파일 업로드 실패" + file.getOriginalFilename());
        }

    }


}
