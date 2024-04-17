package prac8;

class Main {
    public static void main(String[] args) {
        System.out.println("Рисуем флаг России:");
        AbstractThreeRowsFlag russianFlag = new RussianFlag();
        russianFlag.drawFlag();

        var v = new Visitor();
        v.visit((Element) russianFlag);
    }
}