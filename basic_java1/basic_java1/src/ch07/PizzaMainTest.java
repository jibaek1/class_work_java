package ch07;

public class PizzaMainTest {

    public static void main(String[] args) {

        Pizza f1 = new Pizza();
        Pizza f2 = new Pizza();

        System.out.println(f1);
        System.out.println(f2);

        f1.price = 20000;
        f2.price = 25000;

        System.out.println(f1.price);
        System.out.println(f2.price);


    }

}
