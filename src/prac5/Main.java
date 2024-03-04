package prac5;

public class Main {
    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance()); // true
        System.out.println(EnumSingleton.INSTANCE == EnumSingleton.INSTANCE); // true
        System.out.println(StaticFieldSingleton.getInstance() == StaticFieldSingleton.getInstance()); //true
    }
}