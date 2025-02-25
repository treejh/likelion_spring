package restful실습.product실습.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private double price;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
