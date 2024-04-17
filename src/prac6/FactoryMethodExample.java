package prac6;

public class FactoryMethodExample {
    // Интерфейс продукта
    interface Product {
        void operation();
    }

    // Конкретная реализация продукта ProductA
    class ConcreteProductA implements Product {
        @Override
        public void operation() {
            System.out.println("ConcreteProductA");
        }
    }

    // Конкретная реализация продукта ProductB
    class ConcreteProductB implements Product {
        @Override
        public void operation() {
            System.out.println("ConcreteProductB");
        }
    }

    // Интерфейс фабрики
    interface Factory {
        Product createProduct();
    }

    // Конкретная реализация фабрики для создания продукта ProductA
    class ConcreteFactoryA implements Factory {
        @Override
        public Product createProduct() {
            return new ConcreteProductA();
        }
    }

    // Конкретная реализация фабрики для создания продукта ProductB
    class ConcreteFactoryB implements Factory {
        @Override
        public Product createProduct() {
            return new ConcreteProductB();
        }
    }

    // Пример использования паттерна Фабричный метод
    public class Example {
        public void Run(String[] args) {
            Factory factoryA = new ConcreteFactoryA();
            Product productA = factoryA.createProduct();
            productA.operation();

            Factory factoryB = new ConcreteFactoryB();
            Product productB = factoryB.createProduct();
            productB.operation();
        }
    }

}