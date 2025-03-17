package tdd;

public class CalMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int result = calculator.add(3,4);
        System.out.println(result);
    }
}
