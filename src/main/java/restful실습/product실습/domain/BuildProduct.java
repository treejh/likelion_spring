package restful실습.product실습.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
@AllArgsConstructor
@Builder
public class BuildProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    public BuildProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //DTO -> entity로 변환하는 메서드
    public static BuildProduct formDTO(BuildProductDTO BuildProductDO){
        return BuildProduct.builder()
                .id(BuildProductDO.getId())
                .name(BuildProductDO.getName())
                .price(BuildProductDO.getPrice())
                .build();
    }
}
