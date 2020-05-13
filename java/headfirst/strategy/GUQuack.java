package headfirst.strategy;

public class GUQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack! GGGGo");
    }
}
