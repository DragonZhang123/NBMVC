package headfirst.strategy;

public class RedHeadDuck extends Duck{
    public RedHeadDuck() {
        this.quackBehavior =new GUQuack();
        this.flyBehavior =new BADFly();
    }

    @Override
    public void display() {

        System.out.println("red Head Duck!");
    }
}
