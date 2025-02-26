package restful실습.product실습.service;


import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restful실습.product실습.domain.Product;
import restful실습.product실습.domain.ProductDTO;
import restful실습.product실습.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductDTO addProduct(ProductDTO productDTO){
        if(productDTO.getName().isEmpty()||productDTO.getPrice()<=0){
            throw new RuntimeException("올바른 값을 넣어주세요");
        }
        productRepository.save(new Product(productDTO.getName(),productDTO.getPrice()));
        return productDTO;
    }

    @Transactional
    public List<ProductDTO> getProducts(){
        List<ProductDTO> productDTOList = new ArrayList<>();
        productRepository.findAll().forEach(
                data-> productDTOList.add(new ProductDTO(data)));

        return productDTOList;
    }

    @Transactional
    public ProductDTO getProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("제품을 찾을 수 없습니다"));

        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO updateProduct(Long id,ProductDTO productDTO){
        if(productDTO.getName().isEmpty()||productDTO.getPrice()<=0){
            throw new RuntimeException("올바른 값을 넣어주세요");
        }
        Product product = productRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("수정할 제품을 찾을 수 없습니다"));

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        //return new ProductDTO(product);
        return productDTO;

    }

    @Transactional
    public String deleteProduct(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("삭제할 제품을 찾을 수 없습니다"));
        String name = product.getName();
        productRepository.deleteById(id);

        return "제품 : "+name+" 삭제되었습니다. ";
    }
}
