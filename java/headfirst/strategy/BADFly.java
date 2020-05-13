package headfirst.strategy;

public class BADFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("bad fly!");
    }
}
