package prac6;
public class Main {
    public static void main(String[] args) {
        FactoryMethodExample e1 = new FactoryMethodExample();
        AbstractFactoryExample e2 = new AbstractFactoryExample();
        BuilderExample e3 = new BuilderExample();
        PrototypeExample e4 = new PrototypeExample();

        FactoryMethodExample.Example fm = e1.new Example();
        AbstractFactoryExample.Example af = e2.new Example();
        BuilderExample.Example b = e3.new Example();
        PrototypeExample.Example p = e4.new Example();

        fm.Run(args);
        af.Run(args);
        b.Run(args);
        p.Run(args);
    }
}