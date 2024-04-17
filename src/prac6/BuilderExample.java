package prac6;

public class BuilderExample {
    class Product {
        private String part1;
        private String part2;

        public void setPart1(String part1) {
            this.part1 = part1;
        }

        public void setPart2(String part2) {
            this.part2 = part2;
        }

        public void show() {
            System.out.println("Builder 1: " + part1);
            System.out.println("Builder 2: " + part2);
        }
    }

    // реализация строителя
    class Builder {
        private Product product = new Product();

        public Builder buildPart1() {
            product.setPart1("Builder 1 done");
            return this;
        }

        public Builder buildPart2() {
            product.setPart2("Builder2 done");
            return this;
        }

        public Product getResult() {
            return product;
        }
    }

    public class Example {
        public void Run(String[] args) {
            Builder builder = new Builder();

            Product product = builder
            .buildPart1()
            .buildPart2()
            .getResult();
            
            product.show();
        }
    }

}
