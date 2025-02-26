package restful실습.build실습;



public class PizzaMain {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("피자",true,true,true);
        System.out.println(pizza);


        Pizza pizza2 = Pizza.builder()
                .size("Small")
                .cheese(true)
                .pepperoni(true).build();

        System.out.println(pizza2);

        Pizza pizza3 = Pizza.builder().size("Large").build();
        System.out.println(pizza3);


    }
}
