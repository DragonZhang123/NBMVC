package headfirst.strategy;

public class GreenHeadDuck extends Duck{
    public GreenHeadDuck() {
        this.quackBehavior =new GGQuack();
        this.flyBehavior =new GoosFly();
    }

    @Override
    public void display() {

        System.out.println("green Head Duck!");
    }
}
