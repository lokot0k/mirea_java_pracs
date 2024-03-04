package prac5;

public class StaticFieldSingleton {
    private static final StaticFieldSingleton instance = new StaticFieldSingleton();

    public static StaticFieldSingleton getInstance() {
        return instance;
    }
}
