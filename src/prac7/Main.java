package prac7;

public class Main {
    public static void main(String[] args) {
        Service taro = new Divination("Таро", 1000);
        Service chakra = new Chakra(taro);
        Service aura = new Aura(chakra);

        System.out.println(aura.getPrice());
    }
}
