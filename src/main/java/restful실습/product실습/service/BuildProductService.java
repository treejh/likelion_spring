package restful실습.product실습.service;


import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restful실습.product실습.domain.BuildProduct;
import restful실습.product실습.domain.BuildProductDTO;
import restful실습.product실습.domain.Product;
import restful실습.product실습.domain.ProductDTO;
import restful실습.product실습.repository.BuildProductRepository;
import restful실습.product실습.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class BuildProductService {
    private final BuildProductRepository buildProductRepository;

    @Transactional
    public BuildProductDTO createProduct(BuildProductDTO buildProductDTO){
        BuildProduct buildProduct = BuildProduct.formDTO(buildProductDTO);

        BuildProduct createProduct = buildProductRepository.save(buildProduct);

        return BuildProductDTO.fromProduct(createProduct);

    }

    @Transactional
    public List<BuildProductDTO> getProducts(){
        return buildProductRepository.findAll().stream()
                .map(BuildProductDTO::fromProduct)
                .collect(Collectors.toList());
    }

    @Transactional
    public BuildProductDTO getProductById(Long id){
        BuildProduct buildProduct = buildProductRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("상품이 없어요 : "+id));
        return BuildProductDTO.fromProduct(buildProduct);

    }

    @Transactional
    public BuildProductDTO updateProduct(BuildProductDTO buildProductDTO){
        BuildProduct buildProduct = buildProductRepository.findById(buildProductDTO.getId())
                .orElseThrow(()->new EntityNotFoundException("상품이 없어요 : "+buildProductDTO.getId()));

        Optional.ofNullable(buildProductDTO.getName()).ifPresent(buildProduct::setName);
        if (buildProductDTO.getName() != null ){
        buildProduct.setName(buildProduct.getName());
        }

        if(buildProductDTO.getPrice()!=0.0){
            buildProduct.setPrice(buildProduct.getPrice());
        }

        return BuildProductDTO.fromProduct(buildProduct);

    }

    @Transactional
    public void deleteProduct(Long id){
        BuildProduct buildProduct = buildProductRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("상품이 없어요 : "+id));

        buildProductRepository.deleteById(id);

    }
}
