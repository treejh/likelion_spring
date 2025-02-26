package restful실습.product실습.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class BuildProductDTO {
    private Long id ;
    private String name;
    private double price;

    public static BuildProductDTO fromProduct(BuildProduct buildProduct) {
        return BuildProductDTO.builder()
                .id(buildProduct.getId())
                .name(buildProduct.getName())
                .price(buildProduct.getPrice())
                .build();

    }
}
