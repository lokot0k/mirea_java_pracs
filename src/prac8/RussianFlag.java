package prac8;

class RussianFlag extends AbstractThreeRowsFlag implements Element {

    @Override
    void drawUpperLevel() {
        Colors.paintWhiteColor();
    }

    @Override
    void drawMiddleLevel() {
        Colors.paintBlueColor();
    }

    @Override
    void drawBottomLevel() {
        Colors.paintRedColor();
    }

    @Override
    public void accept() {
        System.out.println("Приянт сигнал из посетителя");
    }
}