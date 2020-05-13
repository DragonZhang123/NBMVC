package headfirst.strategy;

public class GoosFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("good fly!");
    }
}
