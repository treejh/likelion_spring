package restful실습.product실습.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import restful실습.product실습.domain.BuildProductDTO;
import restful실습.product실습.service.BuildProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/products/build")
public class BuildProductController {
    private final BuildProductService buildProductService;

    @GetMapping
    public ResponseEntity<List<BuildProductDTO>> getProducts(){
        return ResponseEntity.ok(buildProductService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildProductDTO> getProduct(@PathVariable("id") Long id){
        return ResponseEntity.ok(buildProductService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<BuildProductDTO> postProduct(@Valid @RequestBody BuildProductDTO buildProductDTO){
        return ResponseEntity.ok(buildProductService.createProduct(buildProductDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuildProductDTO> updateProduct(@PathVariable("id")Long id,
                                                         @RequestBody BuildProductDTO buildProductDTO){
        buildProductDTO.setId(id);
        return ResponseEntity.ok(buildProductService.updateProduct(buildProductDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id")Long id){
        buildProductService.deleteProduct(id);
        //ResponseEntity<Void>
        //return ResponseEntity.noContent().build();

        return ResponseEntity.ok(id + "상품이 삭제되었습니다");

    }

}
