package prac1;
public class Main {
    public static void main(String[] args) {
        var pinCodeTest = new PredicateImpl();
        System.out.println(pinCodeTest.test("")); // false
        System.out.println(pinCodeTest.test("1234")); // true
        System.out.println(pinCodeTest.test("12345")); //false
        System.out.println(pinCodeTest.test("123456")); // true
        System.out.println(pinCodeTest.test("12345a")); //false
    }
}
