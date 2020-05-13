package headfirst.strategy;

public class GGQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("GGQ quack!");
    }
}
