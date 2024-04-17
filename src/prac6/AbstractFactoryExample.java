package prac6;

public class AbstractFactoryExample {
    // Интерфейс для создания продукта A
    interface AbstractProductA {
        void operationA();
    }

    // Интерфейс для создания продукта B
    interface AbstractProductB {
        void operationB();
    }

    // Конкретная реализация продукта A1
    class ConcreteProductA1 implements AbstractProductA {
        @Override
        public void operationA() {
            System.out.println("1 ConcreteProductA1");
        }
    }

    // Конкретная реализация продукта B1
    class ConcreteProductB1 implements AbstractProductB {
        @Override
        public void operationB() {
            System.out.println("1 from ConcreteProductB1");
        }
    }

    // Конкретная реализация продукта A2
    class ConcreteProductA2 implements AbstractProductA {
        @Override
        public void operationA() {
            System.out.println("1 from ConcreteProductB2");
        }
    }

    // Конкретная реализация продукта B2
    class ConcreteProductB2 implements AbstractProductB {
        @Override
        public void operationB() {
            System.out.println("2 from ConcreteProductB2");
        }
    }

    // Интерфейс абстрактной фабрики
    interface AbstractFactory {
        AbstractProductA createProductA();

        AbstractProductB createProductB();
    }

    // Конкретная реализация абстрактной фабрики для создания продуктов A1 и B1
    class ConcreteFactory1 implements AbstractFactory {
        @Override
        public AbstractProductA createProductA() {
            return new ConcreteProductA1();
        }

        @Override
        public AbstractProductB createProductB() {
            return new ConcreteProductB1();
        }
    }

    // Конкретная реализация абстрактной фабрики для создания продуктов A2 и B2
    class ConcreteFactory2 implements AbstractFactory {
        @Override
        public AbstractProductA createProductA() {
            return new ConcreteProductA2();
        }

        @Override
        public AbstractProductB createProductB() {
            return new ConcreteProductB2();
        }
    }

    // Пример использования паттерна Абстрактная Фабрика
    public class Example {
        public void Run(String[] args) {
            AbstractFactory factory1 = new ConcreteFactory1();
            AbstractProductA productA1 = factory1.createProductA();
            AbstractProductB productB1 = factory1.createProductB();

            productA1.operationA();
            productB1.operationB();

            AbstractFactory factory2 = new ConcreteFactory2();
            AbstractProductA productA2 = factory2.createProductA();
            AbstractProductB productB2 = factory2.createProductB();

            productA2.operationA();
            productB2.operationB();
        }
    }

}
