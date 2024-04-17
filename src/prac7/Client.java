package prac7;

public class Client {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("shared1");
        Flyweight flyweight2 = factory.getFlyweight("shared2");

        flyweight1.operation();
        flyweight2.operation();
    }
}
