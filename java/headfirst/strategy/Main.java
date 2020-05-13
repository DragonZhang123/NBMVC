package headfirst.strategy;

public class Main {
    public static void main(String[] args) {
        Duck greenHeadDuck = new GreenHeadDuck();
        Duck redHeadDuck = new RedHeadDuck();

        greenHeadDuck.display();
        greenHeadDuck.Quack();
        greenHeadDuck.swim();
        greenHeadDuck.fly();

        redHeadDuck.display();
        redHeadDuck.Quack();
        redHeadDuck.swim();
        redHeadDuck.fly();
        redHeadDuck.setFlyBehavior(new GoosFly());
        redHeadDuck.fly();
    }
}
