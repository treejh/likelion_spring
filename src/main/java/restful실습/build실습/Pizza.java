package restful실습.build실습;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Builder
public class Pizza {

    private String size;

    @Builder.Default
    private boolean cheese = true;

    @Builder.Default
    private boolean pepperoni = true;

    @Builder.Default
    private boolean mushrooms = true;


    //Pizza.builder().size("Large").build();
//    public Builder size(String size){
//        this.size=size;
//        return this;
//    }



}
