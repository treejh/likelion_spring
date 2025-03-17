package restful실습.product실습.domain;


import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuildProductDTO {

    private Long id ;

    @NotBlank(message ="상품명은 비어있으면 안됩니다.")
    private String name;

    @Min(value = 1, message="가격은 1이상이어야 합니다. ")
    private double price;

    public static BuildProductDTO fromProduct(BuildProduct buildProduct) {
        return BuildProductDTO.builder()
                .id(buildProduct.getId())
                .name(buildProduct.getName())
                .price(buildProduct.getPrice())
                .build();

    }
}
