public class PizzaBuilderMain {
    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilder.Builder
            (12)
            .cheese(true)
            .pepperoni(true)
            .bacon(true)
            .build();
    }
}
